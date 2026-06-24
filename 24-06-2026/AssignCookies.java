import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        int[] greed = { 1, 5, 3, 3, 4 };
        int[] cookies = { 4, 2, 1, 2, 1, 3 };

        System.out.println(optimal(greed, cookies));
    }

    private static int optimal(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0;
        int j = 0;
        while (j < cookies.length) {
            if (greed[i] <= cookies[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}