public class Solution2 {

    private int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        boolean[] marked = new boolean[n];
        int[] fringe = new int[n];
        for (int i = 0; i < n; i++) {
            fringe[i] = Integer.MAX_VALUE;
        }

        int checkPoint = 0;
        marked[0] = true;
        for (int i = 0; i < n - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int temp = checkPoint;  // check point at this turn

            /** Scan all unmarked points and find the nearest one */
            for (int j = 0; j < n; j++) {
                if (!marked[j]) {
                    // update distance with the current check point
                    fringe[j] = Math.min(fringe[j], manhattan(points[checkPoint], points[j]));
                    // find the nearest point
                    if (fringe[j] < minDist) {
                        minDist = fringe[j];
                        temp = j;
                    }
                }
            }
            // update next check point and add value to the result
            checkPoint = temp;
            marked[checkPoint] = true;
            res += minDist;
        }
        return res;
    }
}