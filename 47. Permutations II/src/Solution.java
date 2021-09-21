import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Use Set to detect duplicate
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
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
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!marked[i] && !unique.contains(nums[i])) {
                unique.add(nums[i]);
                arr.add(nums[i]);
                marked[i] = true;

                dfs(res, arr, marked, n, depth + 1, nums);

                marked[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
