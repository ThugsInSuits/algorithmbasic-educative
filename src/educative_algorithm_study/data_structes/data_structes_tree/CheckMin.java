package educative_algorithm_study.data_structes.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 19:47
 * Version 1.0
 * @description
 **/
public class CheckMin {
    public static int findMin(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }

    public static int findMinRecursive(Node root) {
        if (root == null) {
            return -1;
        }else if (root.getLeftChild() ==null) {
            return root.getData();
        }else {
            return findMin(root.getLeftChild());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println(findMinRecursive(bsT.getRoot()));

    }
}
