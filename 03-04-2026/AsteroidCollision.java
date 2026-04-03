import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] nums) {
        List<Integer> st = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                st.add(num);
            } else {
                while (!st.isEmpty() && st.get(st.size() - 1) > 0
                        && Math.abs(num) > st.get(st.size() - 1)) {
                    st.remove(st.size() - 1);
                }

                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(num)) {
                    st.remove(st.size() - 1);
                } else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(num);
                }
            }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = { 5, 10, -5, -10, 8, -8, -3, 12 };
        System.out.println("Asteroids After Collision is: " + Arrays.toString(asteroidCollision(nums)));
    }
}