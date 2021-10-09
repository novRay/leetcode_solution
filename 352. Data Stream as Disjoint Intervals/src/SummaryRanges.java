import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SummaryRanges {
    List<Integer> stream;
    public SummaryRanges() {
        stream = new ArrayList<>();
    }

    public void addNum(int val) {
        stream.add(val);
        stream.sort(Comparator.naturalOrder());
    }

    public int[][] getIntervals() {
        int n = stream.size();
        List<int[]> res = new ArrayList<>();
        int cnt = 0;
        res.add(new int[]{stream.get(0), stream.get(0)});
        for (int i = 1; i < n; i++) {
            if (stream.get(i) - stream.get(i - 1) <= 1) {
                continue;
            }
            res.get(cnt++)[1] = stream.get(i - 1);
            res.add(new int[]{stream.get(i), stream.get(i)});
        }
        res.get(cnt)[1] = stream.get(n - 1);
        int[][] ans = new int[res.size()][2];
        return res.toArray(ans);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */