package educative_algorithm_study.data_structes.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 20:16
 * Version 1.0
 * @description
 **/
public class CheckAncestors {
    public static String findAncestors(Node root, int k) {
        String result = "";
        Node temp = root;
        while (temp != null && temp.getData() != k) {
            result = result + temp.getData() + ",";
            if (temp.getData() >= k) {
                temp = temp.getLeftChild();
            }else {
                temp = temp.getRightChild();
            }
        }
        if (temp == null ) {
            return "";
        }
        return result;
    }
    // Driver code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));
    }

}
