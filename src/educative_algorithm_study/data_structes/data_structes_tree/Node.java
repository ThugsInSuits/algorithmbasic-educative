package educative_algorithm_study.data_structes.data_structes_tree;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 17:35
 * Version 1.0
 * @description
 **/
public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    Node(int value) {
        this.data = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
