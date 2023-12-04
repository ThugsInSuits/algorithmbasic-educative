package educative_algorithm_study.data_structes.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 22:15
 * Version 1.0
 * @description
 **/
public class NthElementChallenge {
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        SinglyLinkedList<T>.Node temp = list.getHeadNode();

        int fromStartIndex = list.getSize() - n;
        if (list.getSize() == 0 || fromStartIndex > list.getSize() || fromStartIndex < 0) {
            return null;
        }
        while (fromStartIndex > 0) {
            temp = temp.nextNode;
            fromStartIndex--;
        }

        return temp.data;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 9));//will return null
    }
}
