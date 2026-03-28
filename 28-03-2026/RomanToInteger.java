import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInteger(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        romanTable(mp);

        int total = 0;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (i + i < sLen && mp.get(ch) < mp.get(s.charAt(i + 1))) {
                total -= mp.get(ch);
            } else {
                total += mp.get(ch);
            }
        }
        return total;
    }

    public static void romanTable(Map<Character, Integer> mp) {
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
    }

    public static void main(String[] args) {
        String s = "XLII";
        System.out.println("The Value of Roamn in Integer is: " + romanToInteger(s));
    }
}