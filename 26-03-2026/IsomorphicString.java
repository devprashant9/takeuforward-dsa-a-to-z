public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            if (sFreq[s.charAt(i)] != tFreq[t.charAt(i)]) {
                return false;
            }
            sFreq[s.charAt(i)] = i + 1;
            tFreq[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println("Given Strings are Isomorphic? " + isIsomorphic(s, t));
    }
}