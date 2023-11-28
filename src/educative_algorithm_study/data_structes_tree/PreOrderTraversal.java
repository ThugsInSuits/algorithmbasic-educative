package educative_algorithm_study.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 21:56
 * Version 1.0
 * @description
 **/
public class PreOrderTraversal {
    public static void preTraverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getData()+",");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());
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

        PreOrderTraversal.preTraverse(BST.getRoot());
    }
}
