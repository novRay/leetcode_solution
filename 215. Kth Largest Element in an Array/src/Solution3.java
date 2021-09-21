import java.util.Random;

/** Quick select with Hoare partition
 *  O(N)
 * */
public class Solution3 {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        return nums[n - k];
    }
    private static void quickSelect(int[] nums, int start, int end, int k) {
        while (start < end) {
            int index = hoarePartition(nums, start, end);
            if (index < k) {
                start = index + 1;
            } else if (index > k) {
                end = index - 1;
            } else {
                break;
            }
        }
    }

    private static int hoarePartition(int[] nums, int start, int end) {
        Random ran = new Random();
        int x = ran.nextInt(end - start) + start;
        swap(nums, x, start);
        int pivot = nums[start];
        int l = start + 1;
        int g = end;
        while (l <= g) {
            while (l <= g && nums[l] < pivot) {
                l++;
            }
            while (l <= g && nums[g] > pivot) {
                g--;
            }
            if (l <= g) {
                swap(nums, l, g);
                l++;
                g--;
            }
        }
        swap(nums, start, g);
        return g;
    }

    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1};
        int res = findKthLargest(a, 1);
        System.out.println(res);
    }
}
