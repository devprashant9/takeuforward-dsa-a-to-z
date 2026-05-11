public class RequirementsForTree {

    // 1 -> PreOrder 2 -> InOrder 3 -> PostOrder
    public static boolean isTreePossible(int a, int b) {
        if (a == 2 && b == 2) {
            return false;
        }

        if (a == 2 || b == 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Tree From PreOrder & InOrder Possible? " + (isTreePossible(1, 2)));
        System.out.println("Tree From PostOrder & InOrder Possible? " + (isTreePossible(3, 2)));
        System.out.println("Tree From InOrder & InOrder Possible? " + (isTreePossible(2, 2)));
        System.out.println("Tree From PreOrder & PostOrder Possible? " + (isTreePossible(1, 3)));
    }
}