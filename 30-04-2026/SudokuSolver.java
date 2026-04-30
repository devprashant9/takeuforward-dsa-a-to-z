import java.util.Arrays;

public class SudokuSolver {

    public static boolean isCellValid(char[][] board, int r, int c, int num) {

        // check entire row
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] != '.' && board[r][i] - '0' == num) {
                return false;
            }
        }

        // check entire column
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] != '.' && board[i][c] - '0' == num) {
                return false;
            }
        }

        // check small square
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] != '.' && board[i][j] - '0' == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(char[][] board, int r, int c) {
        // row ends soduku over successfully placed all numbers correctly
        if (r == 9) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }

        // column ended move to next row
        if (c == 9) {
            return solveSudoku(board, r + 1, 0);
        }

        // already digit move to next cell
        if (board[r][c] != '.') {
            return solveSudoku(board, r, c + 1);
        }

        // empty place try 1 to 9, if valid move to next cell else backtrack
        for (int i = 1; i <= 9; i++) {
            if (isCellValid(board, r, c, i)) {
                board[r][c] = (char) (i + '0');
                if (solveSudoku(board, r, c + 1))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(solveSudoku(board, 0, 0));
        ;
    }
}