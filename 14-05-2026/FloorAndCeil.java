import java.util.ArrayList;
import java.util.List;

public class FloorAndCeil {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static List<Integer> floorAndCeil(Node root, int data) {
        List<Integer> ans = new ArrayList<>();

        int floor = -1;
        int ceil = -1;
        Node curr = root;
        while (curr != null) {

            if (curr.data == data) {
                floor = ceil = curr.data;
                break;
            }

            if (data < curr.data) {
                ceil = curr.data;
                curr = curr.left;
            } else {
                floor = curr.data;
                curr = curr.right;
            }
        }

        ans.add(floor);
        ans.add(ceil);

        return ans;
    }
}