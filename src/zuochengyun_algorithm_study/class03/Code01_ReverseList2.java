package zuochengyun_algorithm_study.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表反转
 * 双链表反转
 */
public class Code01_ReverseList2 {
    static class Node{
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;
        public DoubleNode(int value){
            this.value = value;
        }
    }

    /**
     * 反转单链表
     * 不使用容器，空间负责度为1
     * 使用虚拟指针
     *
     * 1.把节点next的保存
     * 2.保存之后把置为空
     * @param head
     */
    public static  Node reverseSingleLink(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int len = 10;
        int value = 30;
        int testTime = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            Node node = generateRandomLinkedList(len,value);
            List<Integer> list1 = getOrigionLinkedList(node);
            node = reverseSingleLink(node);
            if (!checkLinkedList(node,list1)) {
                System.out.println("single oops");
            }

            DoubleNode doubleNode = generateRandomDoubleLinkedList(len,value);
            List<Integer> list2 = getDoubleOrigionLinkedList(doubleNode);
            doubleNode = reverseDoubleList(doubleNode);
            if (!checkDoubleLinkedList(doubleNode,list2) ) {
                System.out.println("double oop");
            }
        }
        System.out.println("test end");
    }

    private static boolean checkDoubleLinkedList(DoubleNode doubleNode, List<Integer> list2) {
        for (int i = list2.size() -1 ;i>=0;i--) {
            if (!list2.get(i).equals(doubleNode.value)) {
                return false;
            }
            doubleNode = doubleNode.next;
        }
        return true;
    }

    private static List<Integer> getDoubleOrigionLinkedList(DoubleNode doubleNode) {
        List<Integer> originList = new ArrayList<>();
        while(doubleNode != null) {
            originList.add(doubleNode.value);
            doubleNode = doubleNode.next;
        }
        return originList;
    }

    private static DoubleNode generateRandomDoubleLinkedList(int len, int value) {
        int size = (int)(Math.random()*(len + 1));
        if (size == 0) {
            return null;
        }
        DoubleNode head = new DoubleNode((int)(Math.random()*(len + 1)));
        DoubleNode pre = head;
        size--;
        while (size != 0) {
            DoubleNode next = new DoubleNode((int)(Math.random()*(len + 1)));
            pre.next = next;
            next.last = pre;
            pre = next;
            size--;
        }
        return head;
    }

    private static boolean checkLinkedList(Node node, List<Integer> list1) {
        for (int i = list1.size() - 1;i >= 0 ;i--) {
            if (!list1.get(i).equals(node.val)) {
                return false;
            }
            node = node.next;
        }
        return true;

    }

    private static List<Integer> getOrigionLinkedList(Node node1) {
        List<Integer> list = new ArrayList<>();
        while (node1 != null) {
            list.add(node1.val);
            node1 = node1.next;
        }
        return list;
    }

    private static Node generateRandomLinkedList(int len, int value) {
        int size = (int)(Math.random()*(len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int)(Math.random()*(len + 1)));
        Node pre = head;
        while(size != 0) {
            Node next = new Node((int)(Math.random()*(len + 1)));
            pre.next = next;
            pre = next;
            size--;
        }
        return head;
    }


}
