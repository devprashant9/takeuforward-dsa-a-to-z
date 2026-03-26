public class RotateString {

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String doubledS = s + s;
        return doubledS.contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println("Goal is Achievable? " + rotateString(s, goal));
    }
}
