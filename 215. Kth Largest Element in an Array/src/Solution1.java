import java.util.Random;

/** Quick sort with Hoare partition
 * */
public class Solution1 {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums[n - k];
    }
    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int newPivotIndex = hoarePartition(nums, start, end);
            quickSort(nums, start, newPivotIndex);
            quickSort(nums, newPivotIndex + 1, end);
        }
    }
    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public static int hoarePartition(int[] a, int low, int high)
    {
        Random ran = new Random();
        int x = ran.nextInt(high - low) + low;
        int pivot = a[x];
        int lo = low - 1;
        int hi = high + 1;
        while (true) {
            do {
                lo += 1;
            } while (a[lo] < pivot);
            do {
                hi -= 1;
            } while (a[hi] > pivot);
            if (lo >= hi) {
                return hi;
            }
            swap(a, lo, hi);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        int res = findKthLargest(a, 2);
        System.out.println(res);
    }
}
