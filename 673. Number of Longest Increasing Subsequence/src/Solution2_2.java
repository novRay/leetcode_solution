import java.util.ArrayList;
import java.util.List;

public class Solution2_2 {
    public int findNumberOfLIS(int[] nums) {
        List<List<int[]>> list = new ArrayList<>();
        for (int num : nums) {
            int len = bsearch1(list, num);
            int count = 1;
            if (len > 0) {
                List<int[]> prev = list.get(len - 1);
                int p = bsearch2(prev, num);
                count = prev.get(prev.size() - 1)[1] - (p == 0 ? 0 : prev.get(p - 1)[1]);
            }
            if (len == list.size()) {   // length is updated
                list.add(new ArrayList<>());
                list.get(len).add(new int[] {num, count});
            } else {
                List<int[]> curr = list.get(len);
                int[] last = curr.get(curr.size() - 1);
                if (last[0] == num) {
                    last[1] += count;
                } else {
                    curr.add(new int[] {num, last[1] + count});
                }
            }
        }
        List<int[]> t = list.get(list.size() - 1);
        return t.get(t.size() - 1)[1];
    }
    /**
     * Returns first index >= key. Note:
     * a. Sequence of elements i.e. list.get(i).get(list.get(i).size()-1)[0] is sorted in increasing order
     * b. list.size() is returned if size is 0 or all elements are < key
     */
    private int bsearch1(List<List<int[]>> list, int key) {
        int l = 0, r = list.size();
        while(l < r) {
            int m = (l + r) / 2;
            if(list.get(m).get(list.get(m).size() - 1)[0] < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    /**
     * Returns first index < key. Note:
     * a. Sequence of elements i.e. list.get(i)[0] is sorted in decreasing order
     * b. It is guaranteed that list contains at least one element < key
     */
    private int bsearch2(List<int[]> list, int key) {
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int m = (l + r) / 2;
            if(list.get(m)[0] >= key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
