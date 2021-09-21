import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// HashSet version
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> columns = new ArrayList<>(9);
        List<Set<Character>> boxes = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (rows.get(i).contains(c) || columns.get(j).contains(c) || boxes.get(i / 3 * 3 + j / 3).contains(c)) {
                        return false;
                    }
                    rows.get(i).add(c);
                    columns.get(j).add(c);
                    boxes.get(i / 3 * 3 + j / 3).add(c);
                }
            }
        }
        return true;
    }
}
