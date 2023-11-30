package educative_algorithm_study.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 19:53
 * Version 1.0
 * @description
 **/
public class CheckKthMax {
    public static int findKthMax(Node root,int k) {
        StringBuilder sb = new StringBuilder();
        sb = inOrderTraversal(root,sb);
        String[] arr = sb.toString().split(",");
        if ((arr.length - k) >= 0) {
            return Integer.parseInt(arr[arr.length - k]);
        }
        return -1;
    }

    private static StringBuilder inOrderTraversal(Node root, StringBuilder sb) {
        if (root.getLeftChild() != null) {
            inOrderTraversal(root.getLeftChild(),sb);
        }
        sb.append(root.getData()).append(",");
        if (root.getRightChild() != null) {
            inOrderTraversal(root.getRightChild(),sb);
        }
        return sb;
    }

    public static int  counter; //global count variable
    //used as a wrapper for the recursive algorithm
    public static int findKthMax2(Node root, int k) {
        counter = 0;
        Node node = findKthMaxRecursive(root, k);
        if(node != null)
            return node.getData();
        return -1;
    }

    public static Node findKthMaxRecursive(Node root, int k) {
        if(root==null){
            return null;
        }
        //Recursively reach the right-most node (which has the highest value)
        Node node = findKthMaxRecursive(root.getRightChild(), k);

        if(counter != k){
            //Increment counter if kth element is not found
            counter++;
            node = root;
        }
        //Base condition reached as kth largest is found
        if(counter == k){
            return node;
        }else{
            //Traverse left child if kth element is not reached
            return findKthMaxRecursive(root.getLeftChild(), k);
        }
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);

        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMax2(bsT.getRoot(),3));
    }
}
