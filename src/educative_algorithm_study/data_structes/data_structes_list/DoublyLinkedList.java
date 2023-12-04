package educative_algorithm_study.data_structes.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 16:39
 * Version 1.0
 * @description
 **/
public class DoublyLinkedList<T> {
    public class Node{
        public T data;
        public Node nextNode;
        public Node preNode;
    }
    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedList(){
        this.headNode = null;
        size = 0;
        this.tailNode = null;
    }

    public boolean isEmpty(){
        return this.headNode == null && this.tailNode == null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        newNode.preNode = null;
        if (!isEmpty()) {
            headNode.preNode = newNode;
        }else {
            tailNode = newNode;
        }
        headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        newNode.preNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        headNode = headNode.nextNode;
        if (headNode == null) {
            tailNode = null;
        }else {
            headNode.preNode = null;
        }
        size--;
    }

    public void deleteAtTail(){
        if(isEmpty()) {
            return;
        }
        tailNode = tailNode.preNode;
        if (tailNode == null ) {
            headNode = null;
        }else {
            tailNode.nextNode = null;
        }
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
        dll.insertAtEnd(-1);
        dll.printList();
    }
}
