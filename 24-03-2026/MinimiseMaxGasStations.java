import java.util.Arrays;

public class MinimiseMaxGasStations {

    public static double minimiseMaxDistance(int[] nums, int k) {
        int[] placedArray = new int[nums.length - 1];
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxIndex = -1;

            for (int i = 0; i < nums.length - 1; i++) {
                double sectorDiff = nums[i + 1] - nums[i];
                double sectionLength = sectorDiff / (placedArray[i] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            placedArray[maxIndex]++;
        }

        double maxAns = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            double diff = nums[i + 1] - nums[i];
            double sectionLength = diff / (placedArray[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 10;
        System.out.println("Minimised Maximum Distance Between Gas Stations is: " +Arrays.toString(nums));
        System.out.println(minimiseMaxDistance(nums, k));
    }
}