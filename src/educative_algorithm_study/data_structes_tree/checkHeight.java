package educative_algorithm_study.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 20:25
 * Version 1.0
 * @description
 **/
public class checkHeight {
    public static int findHeight(Node root) {
        if (root == null) {
            return -1;
        }else {
            return  1 + Math.max(findHeight(root.getRightChild()),findHeight(root.getLeftChild()));
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
        bsT.add(12);

        System.out.println(findHeight(bsT.getRoot()));

    }
}
