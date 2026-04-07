public class StringTest3 {

    public static int removeCharacters(String s) {
        int sLen = s.length();
        int counter = 0;
        int remove = 0;
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                if (counter == 0) {
                    remove++;
                } else {
                    counter--;
                }
            }
        }
        return remove + counter;
    }

    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(removeCharacters(s));
    }
}
