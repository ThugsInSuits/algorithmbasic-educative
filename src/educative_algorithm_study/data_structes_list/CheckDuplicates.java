package educative_algorithm_study.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 21:16
 * Version 1.0
 * @description
 **/
public class CheckDuplicates {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        SinglyLinkedList<T>.Node compare = null;
        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) {
                    compare.nextNode = compare.nextNode.nextNode;
                }else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 9; i++)
            list.insertAtEnd(i);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        System.out.print("Before ");
        list.printList();
        removeDuplicates(list);
        System.out.print("After ");
        list.printList();

    }
}
