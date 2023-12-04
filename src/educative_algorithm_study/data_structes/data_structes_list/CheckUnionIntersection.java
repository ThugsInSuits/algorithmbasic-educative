package educative_algorithm_study.data_structes.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 21:31
 * Version 1.0
 * @description
 **/
public class CheckUnionIntersection {
    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if (list1.isEmpty() && !list2.isEmpty()) {
            return list2;
        }
        if (!list1.isEmpty() && list2.isEmpty()) {
            return list1;
        }
        if (list1.isEmpty() && list2.isEmpty()) {
            return null;
        }

        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = list2.getHeadNode();
        CheckDuplicates.removeDuplicates(list1);
        return list1;
    }

    public static <T> boolean contains(SinglyLinkedList<T> list ,T data) {
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        if (list1.isEmpty()) {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }

        SinglyLinkedList<T>.Node cureent = list1.getHeadNode();
        while (cureent != null) {
            if (contains(list2,cureent.data)) {
                result.insertAtHead(cureent.data);
            }
            cureent = cureent.nextNode;
        }
        return result;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for(int i=7; i>3; i--){
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for(int i=0; i<5; i++){
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        intersection(list1, list2).printList();
        System.out.print("After Union ");
        union(list1, list2).printList();
    }
}
