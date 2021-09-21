public class Solution4 {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        heapSort(nums, k, n);
        return nums[n - k];
    }

    private static void heapSort(int[] nums, int k, int n) {
        // heapify the array, O(NlogN)
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(nums, i, n);
        }
        // iterate from last item for k times, O(k*logN)
        int i = n - 1;
        while (k > 0) {
            swap(nums, 0, i); // swap the largest with the last
            i--;                // 'delete' the last item(the largest)
            sink(nums, 0, i); // sink the top item to its right place
            k--;
        }
    }

    private static void sink(int[] nums, int k, int n) {
        // left child index = 2 * k + 1
        while (2 * k + 1 < n) {
            int childIndex = 2 * k + 1; // left child index
            // if right child exists and it is larger than the left
            if (childIndex + 1 < n && nums[childIndex + 1] > nums[childIndex]) {
                childIndex += 1;    // choose the right child
            }
            // if parent value larger than two children, then done
            if (nums[k] > nums[childIndex]) {
                break;
            }
            swap(nums, k, childIndex); // swap the larger child with its parent
            k = childIndex; // check next level children
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, -1, 5, 4, 0};
        int x = findKthLargest(a, 5);
        System.out.print(x);
    }
}
