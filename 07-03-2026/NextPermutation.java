class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int breakPoint = -1;
        int nextGreater = Integer.MAX_VALUE;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i >= breakPoint; i--) {
                if (nums[i] > nums[breakPoint]) {
                    nextGreater = i;
                    break;
                }
            }

            int temp = nums[breakPoint];
            nums[breakPoint] = nums[nextGreater];
            nums[nextGreater] = temp;

            reverseArray(nums, breakPoint + 1, nums.length - 1);
        }
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}