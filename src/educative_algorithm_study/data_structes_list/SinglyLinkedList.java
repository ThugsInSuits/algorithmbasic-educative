package educative_algorithm_study.data_structes_list;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/24 10:41
 * Version 1.0
 * @description
 **/
public class SinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
    }

    private Node headNode;
    private int size;

    public Node getHeadNode() {
        return headNode;
    }

    public int getSize() {
        return size;
    }

    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    public boolean isEmpty(){
        if (headNode == null) return true;
        return false;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
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

        Node lastNode = headNode;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        lastNode.nextNode = newNode;
        size++;

    }

    public void insertAfter(T data, T previouse) {
        Node newNode = new Node();
        newNode.data = data;
        Node currentNode = this.headNode;
        while(currentNode != null && !currentNode.data.equals(previouse) ) {
            currentNode = currentNode.nextNode;
        }
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public boolean searchNode(T data) {
        Node temp = headNode;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.nextNode;
        }
        if (temp != null && temp.data.equals(data)) {
            return true;
        }

        return false;
    }

    public void deleteAtHead(){
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    public void printList()  {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List: ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + "->");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + "-> null");


    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node currentNode = headNode;
        Node preNode = null;
        if (currentNode.data.equals(data)) {
            deleteAtHead();
            return;
        }
        while (currentNode != null) {
            if (data.equals(currentNode.data)) {
                preNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            preNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    public int length(){
        Node current = headNode;
        int count = 0;
        while (current != null) {
            current = current.nextNode;
            count++;
        }
        return count;
    }

    /**
     *@Author XiZhuangBaoTu
     *@Description //快慢针，走一步的先到中点，慢的走到中间
     *@Date 17:43 2023/11/24
     *@Param []
     *@return int
     **/
    public T checkMid() {
        if (isEmpty()) {
            return null;
        }

        Node current = headNode;
        Node midNode = headNode;
        while (midNode != null && current != null && current.nextNode != null) {
            current = current.nextNode.nextNode;
            if (current != null) {
                midNode = midNode.nextNode;
            }

        }
        return midNode.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.printList();
        for (int i = 1; i <= 10; i++) {
            list.insertAtEnd(i);
        }
        list.printList();
        list.deleteByValue(3);
        list.printList();
        System.out.println(list.length());
        System.out.println(list.checkMid());

//        list.insertAfter(999,5);
//        for (int i = 1; i <= 10; i++) {
//            list.insertAtEnd(i);
//        }

//        System.out.println("search  "+list.searchNode(999));
    }
}
