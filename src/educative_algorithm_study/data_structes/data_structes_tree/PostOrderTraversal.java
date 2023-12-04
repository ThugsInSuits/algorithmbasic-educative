package educative_algorithm_study.data_structes.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 22:17
 * Version 1.0
 * @description
 **/
public class PostOrderTraversal {
    public static void postTraverse(Node root) {
        if (root == null) return;
        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.print(root.getData() + ",");
    }
    public static void main(String[] args)
    {
        BinarySearchTree BST = new BinarySearchTree();
        BST.add(6);
        BST.add(4);
        BST.add(2);
        BST.add(5);
        BST.add(9);
        BST.add(8);
        BST.add(12);

        PostOrderTraversal.postTraverse(BST.getRoot());

    }
}
