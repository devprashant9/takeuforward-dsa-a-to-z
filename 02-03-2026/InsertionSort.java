import java.util.Arrays;

class InsertionSort {

    public static int[] insertionSort(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swapNumbers(nums, j, j - 1);
                j--;
            }
        }
        return nums;
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 3, 2, 1, 0 };
        insertionSort(nums);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}

// TC: O(n*n)
// SC: O(1)

// Pick element and place it at correct position, works best if array is nearly
// sorted
// it's a stable sort alorithm and goes to n*n in worst case
// best example when we want array to be always sorted whenever a new item is
// added
// doesnt takes up extra space