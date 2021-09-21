import java.util.Random;

/** Quick select with Lomuto partition
 * */
public class Solution2 {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        return nums[n - k];
    }
    private static void quickSelect(int[] nums, int start, int end, int k) {
        while (start < end) {
            int index = lomutoPartition(nums, start, end);
            if (index < k) {
                start = index + 1;
            } else if (index > k) {
                end = index - 1;
            } else {
                break;
            }
        }
    }

    private static int lomutoPartition(int[] nums, int start, int end) {
        Random ran = new Random();
        int x = ran.nextInt(end - start) + start;
        swap(nums, x, end);
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 5, 4, 3, 2, 1};
        int res = findKthLargest(a, 2);
        System.out.println(res);
    }
}
