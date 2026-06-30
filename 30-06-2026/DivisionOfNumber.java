import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DivisionOfNumber
 */
public class DivisionOfNumber {

    public static void main(String[] args) {
        int n = 36;
        System.out.println(factorsOfNumber(n));
    }

    private static List<Integer> factorsOfNumber(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i != i) {
                    ans.add(i);
                    ans.add(n / i);
                } else {
                    ans.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}