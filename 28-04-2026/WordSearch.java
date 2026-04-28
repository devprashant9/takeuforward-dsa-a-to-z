
public class WordSearch {

    static void exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (helper(r, c, board, visited, word, 0)) {
                    System.out.println("true");
                    return;
                }
            }
        }

        System.out.println("false");
    }

    public static boolean helper(int r, int c, char[][] board, boolean[][] visited, String s, int i) {

        if (i == s.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
                visited[r][c] || board[r][c] != s.charAt(i))
            return false;

        visited[r][c] = true;

        boolean found = helper(r, c + 1, board, visited, s, i + 1) ||
                helper(r + 1, c, board, visited, s, i + 1) ||
                helper(r, c - 1, board, visited, s, i + 1) ||
                helper(r - 1, c, board, visited, s, i + 1);

        visited[r][c] = false;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' },
        };
        String word = "ABCCED";
        exist(board, word);
    }
}