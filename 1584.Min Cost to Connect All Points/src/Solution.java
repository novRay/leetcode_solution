import java.util.*;

public class Solution {

    private class Edge {
        int from;
        int to;
        int distance;
        public Edge(int f, int t, int d) {
            from = f;
            to = t;
            distance = d;
        }
    }
    private int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, manhattan(points[i], points[j])));
            }
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a.distance));
        for (Edge e: edges) {
            int v = e.from;
            int w = e.to;
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                res += e.distance;
            }
        }
        return res;
    }



    private class UnionFind {
        private int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = -1;
            }
        }
        public int find(int v) {
            int boss = parents[v];
            if (boss < 0) {
                return v;
            }
            int root = find(boss);
            parents[v] = root;
            return root;
        }
        public boolean connected(int v1, int v2) {
            return find(v1) == find(v2);
        }
        public void union(int v1, int v2) {
            int pv1 = find(v1);
            int pv2 = find(v2);
            if (-parents[pv1] > -parents[pv2]) {
                parents[pv1] += parents[pv2];
                parents[pv2] = pv1;
            } else {
                parents[pv2] += parents[pv1];
                parents[pv1] = pv2;
            }
        }

    }

}
