import java.util.Arrays;

class MinToMaxHeap {

    public static int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            heapifyUp(nums, i);
        }
        return nums;
    }

    public static void heapifyUp(int[] nums, int lastIndex) {
        while (lastIndex > 0) {
            int parent = (lastIndex - 1) / 2;

            if (nums[lastIndex] > nums[parent]) {
                swap(nums, lastIndex, parent);
                lastIndex = parent;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 21, 23 };
        System.out.println(Arrays.toString(nums));
        System.out.println("After Converting To Max Heap");
        System.out.println(Arrays.toString(minToMaxHeap(nums)));
    }
}