import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Pre-sort
public class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] marked = new boolean[n];
        List<Integer> arrangement = new ArrayList<>();
        dfs(res, arrangement, marked, n, 0, nums);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> arr, boolean[] marked,
                     int n, int depth, int[] nums) {
        if (depth == n) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && marked[i - 1]) {
                continue;
            }
            if (!marked[i]) {
                arr.add(nums[i]);
                marked[i] = true;

                dfs(res, arr, marked, n, depth + 1, nums);

                marked[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }
}
