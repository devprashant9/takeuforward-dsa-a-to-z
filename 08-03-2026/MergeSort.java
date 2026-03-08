import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        mergeArray(nums, start, mid, end);
    }

    public static void mergeArray(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        int[] ans = new int[high - low + 1];
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                ans[k] = nums[i];
                i++;
                k++;
            } else {
                ans[k] = nums[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            ans[k] = nums[i];
            i++;
            k++;
        }

        while (j <= high) {
            ans[k] = nums[j];
            j++;
            k++;
        }

        for (int k2 = 0; k2 < ans.length; k2++) {
            nums[low + k2] = ans[k2];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 40, 20, 20, 40, 60, 30 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
    }
}