package educative_algorithm_study.algorithms.graph_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/31 16:39
 * Version 1.0
 * @description
 **/
public class DoubleLinkedListGraph {
    int vertices;
    DoublyLinkedList<Integer> adjacencyList[];

    public DoubleLinkedListGraph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source,int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }

    public void printGraph(){
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| =>");
                DoublyLinkedList.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "]->");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }else {
                System.out.println("|" + i + "| => " + "null");
            }

        }
    }

}
