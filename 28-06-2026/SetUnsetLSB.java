/**
 * SetUnsetLSB
 */
public class SetUnsetLSB {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(setRightmostUnsetBit(n));
    }

    private static int setRightmostUnsetBit(int n) {
        return n | n + 1;
    }
}