import java.util.List;

public class GenerateBinaryString {

    public static void generateBinaryStrings(int n, String ans) {
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }

        generateBinaryStrings(n, ans + '0');
        generateBinaryStrings(n, ans + '1');
    }

    public static void generateBinaryStringWithoutConsecutiveOnes(int n, String ans) {
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }

        generateBinaryStringWithoutConsecutiveOnes(n, ans + '0');
        char ch = ans.length() > 0 ? ans.charAt(ans.length() - 1) : '0';
        if (ch != '1') {
            generateBinaryStringWithoutConsecutiveOnes(n, ans + '1');
        }
    }

    public static List<String> binaryStringWithReturn(int n, String ans, List<String> store) {
        if (ans.length() == n) {
            store.add(ans);
            return store;
        }

        binaryStringWithReturn(n, ans + '0', store);
        binaryStringWithReturn(n, ans + '1', store);

        return store;
    }

    public static void main(String[] args) {
       
    }
}