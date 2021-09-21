import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> cmb, int num, int begin) {
        if (target - num == 0) {
            res.add(new ArrayList<>(cmb));
        } else if (target - num > 0){
            for (int i = begin; i < candidates.length; i++) {
                if (target - num - candidates[i] < 0) {
                    break;
                }
                cmb.add(candidates[i]);
                dfs(candidates, target, res, cmb, num + candidates[i], i);
                cmb.remove(cmb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] can = new int[] {2, 3, 6, 7};
        List<List<Integer>> res = s.combinationSum(can, 7);
    }
}
