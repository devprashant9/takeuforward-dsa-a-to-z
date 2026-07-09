import java.util.*;

class WordLadderII {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        Set<String> st = new HashSet<>(wordList);

        if (!st.contains(endWord))
            return ans;

        Queue<List<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(beginWord)));

        st.remove(beginWord);

        while (!q.isEmpty()) {

            int size = q.size();
            Set<String> usedOnLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {

                List<String> sequence = q.remove();

                String lastWord = sequence.get(sequence.size() - 1);

                if (lastWord.equals(endWord)) {
                    if (ans.isEmpty()) {
                        ans.add(new ArrayList<>(sequence));
                    } else if (ans.get(0).size() == sequence.size()) {
                        ans.add(new ArrayList<>(sequence));
                    }
                    continue;
                }

                // No need to explore longer paths once shortest is found
                if (!ans.isEmpty() && sequence.size() >= ans.get(0).size())
                    continue;

                char[] arr = lastWord.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;
                        String nextWord = new String(arr);

                        if (st.contains(nextWord)) {

                            List<String> newSeq = new ArrayList<>(sequence);
                            newSeq.add(nextWord);

                            q.add(newSeq);
                            usedOnLevel.add(nextWord);
                        }
                    }

                    arr[j] = original;
                }
            }

            // Remove words only after finishing the current level
            for (String word : usedOnLevel)
                st.remove(word);
        }

        return ans;
    }
}