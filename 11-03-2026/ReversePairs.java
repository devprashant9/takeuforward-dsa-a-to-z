import java.util.Arrays;

public class ReversePairs {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        count += mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);
        count += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);

        return count;
    }

    public static int countPairs(int[] nums, int start, int mid, int end) {
        int j = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2 * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        return count;
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;

        int[] temp = new int[end - start + 1];
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[start + k2] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 6, 4, 1, 2, 7 };
        System.out.println("Total Reverse Pairs in Array is: " + Arrays.toString(nums));
        System.out.println(reversePairs(nums));
    }
}