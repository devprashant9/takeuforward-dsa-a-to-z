
import java.util.Arrays;

public class CharacterByFrequency {

    public static String frequencySort(String s) {
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        Arrays.sort(freq, (p1, p2) -> p2.freq - p1.freq);

        StringBuilder ans = new StringBuilder();

        for (Pair p : freq) {
            while (p.freq > 0) {
                ans.append(p.ch);
                p.freq--;
            }
        }
        return ans.toString();
    }

    static class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        String s = "raaaajj";
        System.out.println("Character Sorted in Frequency: ");
        System.out.println(frequencySort(s));
    }
}