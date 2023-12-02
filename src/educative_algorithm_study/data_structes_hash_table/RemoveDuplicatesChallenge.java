package educative_algorithm_study.data_structes_hash_table;

import educative_algorithm_study.data_structes_list.SinglyLinkedList;

import java.util.HashSet;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 22:10
 * Version 1.0
 * @description
 **/
public class RemoveDuplicatesChallenge {
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        HashSet<V> hashSet = new HashSet<>();
        SinglyLinkedList<V>.Node currentNode = list.getHeadNode();
        SinglyLinkedList<V>.Node preNode = list.getHeadNode();

        if (!list.isEmpty() && currentNode.nextNode != null) {
            while (currentNode != null) {
                if (hashSet.contains(currentNode.data)) {
                    preNode.nextNode = currentNode.nextNode;
                    currentNode = currentNode.nextNode;
                }else {
                    hashSet.add(currentNode.data);
                    preNode = currentNode;
                    currentNode = currentNode.nextNode;
                }
            }
        }
    }

    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}
