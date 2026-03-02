import java.util.Arrays;

class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swapNumbers(nums, j, j + 1);
                }
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
        bubbleSort(nums);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}

// TC: O(n*n)
// SC: O(1)

// core logic is to find maximum by adjacent comparison and put it at last,
// repeat for remaining elements
// sorting is stable becuase order is maintained
// sorts even if duplicate exists
// can be optimized if array is already sorted
// doesnt needs extra sapce thus works where memory is an issue
// works good for smaller datasets