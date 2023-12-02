package educative_algorithm_study.data_structes_hash_table;

import educative_algorithm_study.data_structes_list.SinglyLinkedList;

import java.util.HashSet;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 22:28
 * Version 1.0
 * @description
 **/
public class CheckUnionIntersection {
    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1,SinglyLinkedList<T> list2 ) {
        if (list1.isEmpty() && list2.isEmpty()) {
            return null;
        }
        if (list1.isEmpty() && !list1.isEmpty()) {
            return list2;
        }
        if (!list1.isEmpty() && list2.isEmpty()) {
            return list1;
        }
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> hashSet = new HashSet<>();
        SinglyLinkedList<T>.Node currentNode = list1.getHeadNode();
        while (currentNode != null) {
            if (!hashSet.contains(currentNode.data)) {
                result.insertAtHead(currentNode.data);
                hashSet.add(currentNode.data);
            }
            currentNode = currentNode.nextNode;
        }
        currentNode = list2.getHeadNode();
        while (currentNode != null) {
            if (!hashSet.contains(currentNode)) {
                result.insertAtHead(currentNode.data);
                hashSet.add(currentNode.data);
            }
            currentNode = currentNode.nextNode;
        }
        return result;
    }

    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> visited = new HashSet<T>();
        //start from the head of list1
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        //Keep iterating list1
        while (current != null) {
            //Add elements to visited set if they have not been visited
            if (!visited.contains(current.data)) {
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        //now take head of list2
        current = list2.getHeadNode();
        //iterate list2
        while (current != null) {
            //add the elements which have been visited before into the result
            if (visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.remove(current.data);
            }
            current = current.nextNode;
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
        intersectionWithHashing(list1, list2).printList();
        System.out.print("After Union ");
        unionWithHashing(list1, list2).printList();
    }
}
