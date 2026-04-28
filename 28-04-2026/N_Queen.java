public class N_Queen {

    public static boolean isQueenSafe(char[][] board, int r, int c) {

        // left diagonal -> both r and c decreases
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 00; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal -> r decreases and c increases
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // vertical up
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static boolean placeQueen(char[][] board, int r) {

        if (r == board.length) {
            printChessBoard(board);
            return true;
        }

        for (int c = 0; c < board[r].length; c++) {
            if (isQueenSafe(board, r, c)) {
                board[r][c] = 'Q';

                if (placeQueen(board, r + 1)) {
                    return true;
                }

                board[r][c] = '_';
            }
        }

        return false;
    }

    public static void printChessBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                { '_', '_', '_', '_' },
                { '_', '_', '_', '_' },
                { '_', '_', '_', '_' },
                { '_', '_', '_', '_' }
        };

        System.out.println(placeQueen(board, 0));
        ;

    }
}