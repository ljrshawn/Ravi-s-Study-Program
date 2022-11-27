import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bfs {
    private final LinkedList<ArrayList<Integer>> map;
    private final LinkedList<Integer> path;

    Bfs() {
        this.map = new LinkedList<>();
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
            this.map.add(link);
        }
    }

    public void implement(int destination, int[][] matrix) {
        read(matrix);

        Stack<Integer> finished = new Stack<>();
        Queue<Integer> active = new LinkedList<>();
        LinkedList<ArrayList<Integer>> parents = new LinkedList<>();

        if (destination != 0) {
            ArrayList<Integer> parent = new ArrayList<>();
            for (int i : this.map.get(0)) {
                active.add(i);
                parent.add(i);
            }
            if (parent.contains(destination)){
                this.path.push(destination);
                this.path.push(0);
            } else {
                finished.push(0);
                parents.add(parent);

                while (!active.isEmpty()) {
                    int d = active.poll();
                    System.out.println(d);

                    parent = new ArrayList<>();
                    for (int i : this.map.get(d)) {
                        if (!active.contains(i) && !finished.contains(i)){
                            active.add(i);
                            parent.add(i);
                        }
                    }
                    finished.push(d);
                    parents.add(parent);
                    if (parent.contains(destination)){
                        this.path.push(destination);
                        this.path.push(d);
                        while (d != 0) {
                            for (int i = 0; i < parents.size(); i++) {
                                if (parents.get(i).contains(d)) {
                                    d = finished.get(i);
                                    this.path.push(d);
                                    active.clear();
                                    break;
                                }
                            }
                        }
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
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};
        Bfs run = new Bfs();

        run.implement(3, matrix);
        run.display();
    }
}
