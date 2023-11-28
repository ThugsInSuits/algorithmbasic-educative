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

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

//        bsT.add(6);
//        bsT.add(4);
//        bsT.add(9);
//        bsT.add(5);
//        bsT.add(2);
//        bsT.add(8);
//        bsT.add(12);
//        bsT.add(10);
//        bsT.add(14);

        bsT.addWithRecursiveInsert(6);
        bsT.addWithRecursiveInsert(4);
        bsT.addWithRecursiveInsert(9);
        bsT.addWithRecursiveInsert(5);
        bsT.addWithRecursiveInsert(2);
        bsT.addWithRecursiveInsert(8);
        bsT.addWithRecursiveInsert(12);
        bsT.addWithRecursiveInsert(10);
        bsT.addWithRecursiveInsert(14);
        System.out.println(">> Tree <<");
        bsT.printTree(bsT.getRoot());

        Node temp = bsT.searchRecursive(bsT.root,5);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        }
        temp = bsT.search(51);
        if (temp != null) {
            System.out.println("\n" + temp.getData() + " found in Tree !");
        }
    }

}
