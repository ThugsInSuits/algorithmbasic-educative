package educative_algorithm_study.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 17:42
 * Version 1.0
 * @description
 **/
public class BinarySearchTree {
    private Node root;

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        Node currentNode = root;
        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (currentNode.getData() > value){
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            }else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    public Node search(int value) {
        if (isEmpty()) {
            return null;
        }

        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getData() == value) {
                return currentNode;
            }
            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            }else {
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println(value + " Not found in the tree!");
        return null;
    }

    public Node searchRecursive(Node currentNode,int value) {
        if (isEmpty()) {
            return null;
        }
        if (currentNode == null || currentNode.getData() == value) {
            return currentNode;
        }
        if (currentNode.getData() > value) {
            return searchRecursive(currentNode.getLeftChild(),value);
        }else {
            return searchRecursive(currentNode.getRightChild(),value);
        }

    }

    public Node recursive_insert(Node currentNode,int value) {
        if (currentNode == null) {
            return  new Node(value);
        }

        if (currentNode.getData() > value) {
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(),value));
        }else if (currentNode.getData() < value){
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(),value));
        }else {
            return currentNode;
        }
        return currentNode;
    }

    public boolean addWithRecursiveInsert(int value) {
        root = recursive_insert(this.root,value);
        return true;
    }

    public boolean delete(int value,Node currentNode) {
        if (currentNode == null) {
            return false;
        }
        Node parent = null;
        while (currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            }else {
                currentNode = currentNode.getRightChild();
            }
        }
        if (currentNode == null) {
            return false;
        }else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode.getData() == root.getData()) {
                setRoot(null);
                return true;
            }else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            }else {
                parent.setRightChild(null);
                return true;
            }
        }else if (currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getLeftChild());
                return true;
            }else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }else {
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        }else if (currentNode.getLeftChild() == null) {
            if (root.getData() == currentNode.getData()) {
                setRoot(currentNode.getRightChild());
                return true;
            }else if (currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }else {
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        }else {
            Node leastNode = findLeastNode(currentNode.getLeftChild());
            int temp = leastNode.getData();
            delete(temp,root);
            currentNode.setData(temp);
            return true;
        }
    }

    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;
        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);
        bsT.add(7);
        bsT.add(8);
        bsT.add(12);
        bsT.add(1);
        bsT.add(15);


        System.out.print("Tree : ");
        bsT.printTree(bsT.getRoot());


        System.out.print("\nDeleting Node 6: ");
        bsT.delete(6, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 15: ");
        bsT.delete(15, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 1: ");
        bsT.delete(1, bsT.getRoot());
        bsT.printTree(bsT.getRoot());
    }
}
