public class SearchInMatrixII {

    public static boolean searchMatrix(int[][] nums, int k) {
        int rowLen = nums.length;
        int colLen = nums[0].length;

        int row = 0;
        int col = colLen - 1;

        while (row < rowLen && col >= 0) {
            int ele = nums[row][col];
            if (ele == k) {
                return true;
            } else if (ele > k) {
                col -= 1;
            } else {
                row += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int k = 5;
        System.out.println("The Element is Prsent in Array: " + searchMatrix(nums, k));
    }
}