import java.util.*;

public class WordLadderI {

    static class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);

        if (!st.contains(targetWord))
            return 0;
        st.remove(startWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            String word = p.word;
            int step = p.step;

            if (word.equals(targetWord))
                return step;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        q.add(new Pair(newWord, step + 1));
                        st.remove(newWord);
                    }
                }
            }
        }
        return -1;
    }
}