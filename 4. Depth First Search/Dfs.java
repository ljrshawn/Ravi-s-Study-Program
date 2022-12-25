import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Dfs {
    private final LinkedList<ArrayList<Integer>> graph;
    private final LinkedList<Integer> path;


    Dfs() {
        this.graph = new LinkedList<>();
        this.path = new LinkedList<>();
    }

    protected void read(int[][] matrix) {
        for (int[] ints : matrix) {
            ArrayList<Integer> link = new ArrayList<>();
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    link.add(j);
                }
            }
            this.graph.add(link);
        }
    }

    public void implement(int destination, int[][] matrix) {
        read(matrix);
        int n = this.graph.size();
        boolean[] finished = new boolean[n];
        Arrays.fill(finished, false);

        Stack<Integer> active = new Stack<>();

        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        if (destination != 0) {
            for (int i : this.graph.get(0)) {
                active.push(i);
                parents[i] = 0;
            }
            if (parents[destination] == 0){
                this.path.push(destination);
                this.path.push(0);
            } else {
                finished[0] = true;

                while (!active.isEmpty()) {
                    int d = active.pop();
//                    System.out.println(d);

                    for (int i : this.graph.get(d)) {
                        if (!active.contains(i) && !finished[i]){
                            active.push(i);
                            parents[i] = d;
                        }
                    }
                    finished[d] = true;
                    if (parents[destination] != -1){
                        this.path.push(destination);
                        while (d != -1) {
                            this.path.push(d);
                            d = parents[d];
                        }
                        break;
                    }
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.path.size(); i++) {
            System.out.print(this.path.get(i));
            if (i < this.path.size() - 1) {
                System.out.print(" -> ");
            } else {
                System.out.print("\n");
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0, 0, 0, 1, 1},
                          {1, 0, 1, 0, 1, 0, 1, 0},
                          {0, 1, 0, 1, 1, 0, 0, 0},
                          {0, 0, 1, 0, 1, 0, 0, 0},
                          {0, 1, 1, 1, 0, 1, 0, 0},
                          {0, 0, 0, 0, 1, 0, 1, 0},
                          {1, 1, 0, 0, 0, 1, 0, 0},
                          {1, 0, 0, 0, 0, 0, 0, 0}};
        Dfs run = new Dfs();

        run.implement(2, matrix);
        run.display();
    }
}
