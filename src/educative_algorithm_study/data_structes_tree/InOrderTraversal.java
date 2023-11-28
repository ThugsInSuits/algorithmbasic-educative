package educative_algorithm_study.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 22:03
 * Version 1.0
 * @description
 **/
public class InOrderTraversal {
    public static void inTraverse(Node root) {
        if (root == null) {
            return;
        }

        inTraverse(root.getLeftChild());
        System.out.print(root.getData() + ",");
        inTraverse(root.getRightChild());
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.add(6);
        BST.add(4);
        BST.add(2);
        BST.add(5);
        BST.add(9);
        BST.add(8);
        BST.add(12);

        InOrderTraversal.inTraverse(BST.getRoot());
    }
}
