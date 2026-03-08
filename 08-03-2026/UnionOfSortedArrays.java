import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArrays {

    public static List<Integer> unionOfSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (list.size() == 0 || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (list.size() == 0 || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < nums1.length) {
            if (list.size() == 0 || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < nums2.length) {
            if (list.size() == 0 || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = { 10, 20, 30, 40, 50, 60 };
        int[] nums2 = { 10, 20, 30 };
        System.out.println("Union of Two Sorted Array is: ");

        System.out.println(unionOfSortedArrays(nums1, nums2));
    }
}