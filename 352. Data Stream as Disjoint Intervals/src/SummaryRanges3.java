import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

class SummaryRanges3 {
    int[] nums;
    public SummaryRanges3() {
        nums = new int[10002];
    }

    public void addNum(int val) {
        if (nums[val] == 0) {
            nums[val] = val + 1;
        }
        find(val);
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            if (nums[i] != 0) {
                int end = find(nums[i]) - 1;
                res.add(new int[]{i, end});
                i = end;
            }
        }
        int[][] ans = new int[res.size()][2];
        return res.toArray(ans);
    }

    private int find(int val) {
        if (nums[val] == 0) {
            return val;
        }
        nums[val] = find(nums[val]);    //path compression
        return nums[val];
    }

    public static void main(String[] args) {
        SummaryRanges3 s = new SummaryRanges3();
        s.addNum(1);
        s.addNum(2);
        s.addNum(3);
        s.addNum(5);
        s.addNum(6);
        s.addNum(4);
        s.getIntervals();
    }
}