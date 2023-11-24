package educative_algorithm_study.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 16:39
 * Version 1.0
 * @description
 **/
public class DoublyLinkedList<T> {
    public class Node{
        private T data;
        private Node nextNode;
        private Node preNode;
    }
    public Node headNode;
    public int size;

    public DoublyLinkedList(){
        this.headNode = null;
    }

    public boolean isEmpty(){
        return this.headNode == null;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        newNode.preNode = null;
        if (headNode != null) {
            headNode.preNode = newNode;
        }
        headNode = newNode;
        size++;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        headNode = headNode.nextNode;
        headNode.preNode = null;
        size--;
    }

    public void printList(){
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node temp = headNode;
        System.out.print("null<-");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + "<->");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + "->null");
    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }
        Node temp = headNode;
        if (temp.data.equals(data)) {
            deleteAtHead();
            return;
        }
        while (temp != null ) {
            if (data.equals(temp.data)) {
                temp.preNode.nextNode = temp.nextNode;
                if (temp.nextNode != null) {
                    temp.nextNode.preNode = temp.preNode;
                }
                size--;
            }
            temp = temp.nextNode;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            dll.insertAtHead(i);
        }
        dll.printList();

        dll.deleteAtHead();
        dll.printList();
        dll.deleteByValue(5);
        dll.printList();
    }
}
