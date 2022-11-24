import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private LinkedList<ArrayList<Integer>> adjList;

    Graph() {
        this.adjList = new LinkedList<>();
    }

    public void matrixToList(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> vertex = new ArrayList<>();
            vertex.add(i);
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    vertex.add(j);
                }
            }
            this.adjList.add(vertex);
        }
    }

    public void display() {
        for (ArrayList<Integer> i : this.adjList) {
            for (int j = 0; j < i.size(); j++) {
                System.out.print(i.get(j));
                if (j < i.size()-1) {
                    System.out.print(" -> ");
                } else {
                    System.out.print("\n");
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1},{1, 0, 1, 1}, {1, 1, 0, 0}, {1, 1, 0, 0}};

        Graph graph = new Graph();
        graph.matrixToList(matrix);
        graph.display();
    }
}