import java.util.*;

class RabinKarp {

    public List<Integer> search(String pat, String txt) {

        List<Integer> ans = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        if (m > n)
            return ans;

        int base = 256;
        int mod = 1000000007;

        long patternHash = 0;
        long textHash = 0;
        long highestPower = 1;

        // base^(m-1)
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Initial hash
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pat.charAt(i)) % mod;
            textHash = (textHash * base + txt.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {

            // Hash matched, verify characters
            if (patternHash == textHash) {
                int j = 0;
                while (j < m && pat.charAt(j) == txt.charAt(i + j)) {
                    j++;
                }

                if (j == m) {
                    ans.add(i);
                }
            }

            // Roll the hash
            if (i < n - m) {
                textHash = (textHash - (txt.charAt(i) * highestPower) % mod + mod) % mod;
                textHash = (textHash * base + txt.charAt(i + m)) % mod;
            }
        }

        return ans;
    }
}