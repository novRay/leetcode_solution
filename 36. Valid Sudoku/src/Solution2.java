// Array version
// Faster than using HashSet since array query complexity is guaranteed to be O(1),
// while HashSet query complexity is amortized to be O(1)

public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int digit = c - '0' - 1;
                    int boxIndex = i / 3 * 3 + j / 3;
                    if (rows[i][digit]|| columns[j][digit] || boxes[boxIndex][digit]) {
                        return false;
                    }
                    rows[i][digit] = true;
                    columns[j][digit] = true;
                    boxes[boxIndex][digit] = true;
                }
            }
        }
        return true;
    }
}
