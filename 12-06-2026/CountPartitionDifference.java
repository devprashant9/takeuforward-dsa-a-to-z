public class CountPartitionDifference {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7 };
        int diff = 1;

        int totalSum = arraySum(arr);

        int numerator = diff + totalSum;

        if (numerator % 2 != 0 || numerator < 0) {
            System.out.println("Not Possible");
        }

        int targetK = numerator / 2;

        // Else Question Boild Down To
        // count subset sum with target K
    }

    private static int arraySum(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }
}
