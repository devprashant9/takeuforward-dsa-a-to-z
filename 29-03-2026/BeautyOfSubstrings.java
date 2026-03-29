public class BeautyOfSubstrings {

    public static int beautySum(String s) {
        int sLen = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < sLen; i++) {
            int[] freq = new int[26];
            for (int j = i; j < sLen; j++) {
                freq[s.charAt(j) - 'a'] += 1;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }
                totalBeauty += maxFreq - minFreq;
            }
        }
        return totalBeauty;
    }

    public static void main(String[] args) {
        String s = "xyx";
        System.out.println("Sum of Beauty of String is: " +beautySum(s));
    }
}
