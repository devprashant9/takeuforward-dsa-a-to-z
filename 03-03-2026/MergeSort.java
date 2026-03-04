import java.util.Arrays;

class MergeSort {

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        mergeArrays(nums, start, mid, end);
    }

    public static void mergeArrays(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        int[] temp = new int[high - low + 1];
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= high) {
            temp[k] = nums[j];
            k++;
            j++;
        }

        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[low + k2] = temp[k2];
        }

    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 3, 1, 4, 4, 0, 2 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}

// TC: O(N log(N))
// SC: O(N)
// Has Recursion Stack Space