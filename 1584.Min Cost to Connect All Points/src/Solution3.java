import java.util.PriorityQueue;

public class Solution3 {
    private static int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        boolean[] marked = new boolean[n];

        int[] distTo = new int[n];
        for (int i = 0; i < n; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> fringe = new PriorityQueue<Node>();
        for (int i = 1; i < n; i++) {
            fringe.add(new Node(i, Integer.MAX_VALUE));
        }

        fringe.add(new Node(0, 0));
        distTo[0] = 0;
        while (!fringe.isEmpty()) {
            Node v = fringe.poll();
            marked[v.index] = true;
            res += v.val;
            for (int i = 0; i < n; i++) {
                if (!marked[i]) {
                    Node other = new Node(i, distTo[i]);
                    int dist = manhattan(points[v.index], points[i]);
                    if (dist < distTo[i]) {
                        distTo[i] = dist;

                        fringe.remove(other);
                        fringe.add(new Node(i, dist));
                    }
                }
            }
        }
        return res;
    }

    private static class Node implements Comparable {
        int index;
        int val;
        public Node(int i, int v) {
            index = i;
            val = v;
        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
            return this.val - other.val;
        }
    }

    public static void main(String[] args) {
        int[][] t = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        minCostConnectPoints(t);
    }
}
