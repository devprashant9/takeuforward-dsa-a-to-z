import java.util.Arrays;

public class AssignCookies {

    public static void assignCookies(int[] students, int[] cookies) {
        Arrays.sort(students);
        Arrays.sort(cookies);

        int j = 0;
        for (int i = 0; i < cookies.length; i++) {
            if (j < students.length && cookies[i] <= students[j]) {
                j++;
            }
        }
        System.out.println(j);
    }

    public static void main(String[] args) {
        int[] students = { 1, 2, 3 };
        int[] cookies = { 1, 1 };
        assignCookies(students, cookies);
    }
}