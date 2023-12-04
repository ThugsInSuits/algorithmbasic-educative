package educative_algorithm_study.data_structes.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 20:28
 * Version 1.0
 * @description
 **/
public class CheckKNodes {
    public static String findNodes(Node root,int k) {
       StringBuilder result = new StringBuilder();
       result = findK(root,k,result);
       return result.toString();
    }

    private static StringBuilder findK(Node root, int k, StringBuilder result) {
        if (root == null) {
            return null;
        }
        if (k == 0) {
            result.append(root.getData()).append(",");
        }else {
            findK(root.getLeftChild(),k-1,result);
            findK(root.getRightChild(),k-1,result);
        }
        return result;
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

        System.out.println(findNodes(bsT.getRoot(), 2));

    }


}
