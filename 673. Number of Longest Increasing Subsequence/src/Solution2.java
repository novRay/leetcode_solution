import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int[] tails = new int[nums.length];
        TreeMap<Integer, Integer>[] dp = new TreeMap[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = new TreeMap<>();
        }
        int size = 0;
        for(int num: nums) {
            int l = 0, r = size;
            while(l != r) {
                int m = (r + l) / 2;
                if(tails[m] >= num) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            tails[l] = num;
            Map.Entry<Integer, Integer> fE = dp[l].firstEntry();
            int curChoices = fE == null ? 0 : fE.getValue();
            if(l > 0) {
                int preChoices = dp[l - 1].firstEntry().getValue();
                Map.Entry<Integer, Integer> cE = dp[l - 1].ceilingEntry(num);
                preChoices -= cE == null ? 0 : cE.getValue();
                dp[l].put(num, curChoices + preChoices);
            } else {
                dp[0].put(num, curChoices + 1);
            }
            if(l == size) {
                size++;
            }
        }
        return dp[size - 1].firstEntry().getValue();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[] {1,2,4,3,5,4,7,2};
        System.out.println(s.findNumberOfLIS(nums));
    }
}
