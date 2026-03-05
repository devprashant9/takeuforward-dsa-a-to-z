import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArrays {

    public static List<Integer> unionOfSortedArray(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (list.size() == 0 || nums1[i] != list.get(list.size() - 1)) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (list.size() == 0 || nums2[j] != list.get(list.size() - 1)) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < nums1.length) {
            if (list.size() == 0 || nums1[i] != list.get(list.size() - 1)) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < nums2.length) {
            if (list.size() == 0 || nums2[j] != list.get(list.size() - 1)) {
                list.add(nums2[j]);
            }
            j++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = { 10, 20, 30, 40, 50 };
        int[] nums2 = { 10, 30, 40 };
        System.out.println("Union of Both Arrays is: ");
        System.out.println(unionOfSortedArray(nums1, nums2));
    }
}