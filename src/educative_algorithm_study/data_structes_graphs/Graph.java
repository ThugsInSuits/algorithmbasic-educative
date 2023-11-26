package educative_algorithm_study.data_structes_graphs;

import educative_algorithm_study.data_structes_list.DoublyLinkedList;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/26 07:46
 * Version 1.0
 * @description
 **/
public class Graph {
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer>[] adjacencyList; //An array of linked lists to store adjacent vertices.

    @SuppressWarnings("unchecked")
    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }

    }

    void printGraph(){
        System.out.println(">>adjaceny List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
//            if (adjacencyList[i] != null) {
                System.out.print("|"  + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
//            }else {
//                System.out.println("|" + i + "| => null");
//            }

        }
    }
    void addEdge(int source,int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }
    public static void main( String args[] ) {
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
