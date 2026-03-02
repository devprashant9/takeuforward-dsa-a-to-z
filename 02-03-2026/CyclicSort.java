import java.util.Arrays;

class CyclicSort {

    public static int[] cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (i == correctIndex) {
                i++;
            } else {
                swapNumbers(nums, i, correctIndex);
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
        int[] nums = { 4, 1, 5, 3, 2 };
        cyclicSort(nums);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}

// TC: O(2n - 1)
// SC: O(1)

// numbers in array alway lie between 0 - N - 1 or 1 - N
// sorting is done in 1 paas
// traversing takes O(N) and worst case we may swap all thus (N - 1)