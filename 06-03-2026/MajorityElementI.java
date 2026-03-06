class MajorityElement {

    public static int majorityElement(int[] nums) {
        int trackingElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == trackingElement) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    trackingElement = nums[i];
                    count++;
                }
            }
        }

        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == trackingElement) {
                maxCount++;
            }
        }
        return maxCount > (nums.length / 2) ? trackingElement : -1;
    }
}