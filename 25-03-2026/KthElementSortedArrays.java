class KthElementSortedArrays {

    public static int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length; // assuming smaller
        int n2 = b.length; // assuming greater

        if (n1 > n2) {
            kthElement(b, a, k); // reverse if a is greater
        }

        int low = Math.max(0, k - n2); // if k = 7 and n1 is 5 we fall short of 2
        int high = Math.max(0, n1); // if k = 2 we atleast need to have 2 elements

        int leftHalf = k;

        while (low <= high) {
            int mid1 = low + ((high - low) / 2);
            int mid2 = leftHalf - mid1;

            int l1 = mid1 > 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid1 < n2 ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 6, 7, 9 };
        int[] nums2 = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println("Kth Element of 2 Sorted Array is: " + kthElement(nums1, nums2, k));
    }
}
