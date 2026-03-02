import java.util.Arrays;

class SelectionSort {

    public static int[] selectionSort(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swapNumbers(nums, i, min);
        }
        return nums;
    }

    public static void swapNumbers(int[] nums, int i, int min) {
        int temp = nums[i];
        nums[i] = nums[min];
        nums[min] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 3, 2, 1, 0 };
        selectionSort(nums);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}

// TC: O(n*n)
// SC: O(1)

// core logic is to find minimum and place it at first and repeat process for
// remaining part of unsorted array
// sorting is not stable becuase order is not maintained
// sorts even if duplicate exists
// even for sorted array complexity is n*n
// doesnt needs extra sapce thus works where memory is an issue
// works good for smaller datasets