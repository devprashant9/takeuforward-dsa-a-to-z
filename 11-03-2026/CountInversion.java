import java.util.Arrays;

public class CountInversion {

    public static int countInversion(int[] nums) {
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
        count += merge(nums, start, mid, end);

        return count;
    }

    public static int merge(int[] nums, int start, int mid, int end) {
        int count = 0;

        int i = start;
        int j = mid + 1;

        int[] temp = new int[end - start + 1];
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1);
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
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 1, 3, 5 };
        System.out.println("Total Inversions in Array is: " + Arrays.toString(nums));
        System.out.println(countInversion(nums));
    }
}