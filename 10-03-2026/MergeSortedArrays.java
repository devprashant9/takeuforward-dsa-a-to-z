import java.util.Arrays;

public class MergeSortedArrays {

    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int j2 = m; j2 < m + n; j2++) {
            nums1[j2] = nums2[j2 - m];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { -5, -2, 4, 5, 0, 0, 0 };
        int m = 4;
        int[] nums2 = { -3, 1, 8 };
        int n = 3;
        mergeSortedArrays(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}