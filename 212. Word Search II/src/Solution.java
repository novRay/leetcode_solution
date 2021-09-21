import java.util.ArrayList;
import java.util.List;

// Trie and DFS backtrack
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode p = buildTrie(words);
        // DFS for every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if found all the target words, stop search(it saves nearly half time on LC)
                if (res.size() == words.length) {
                    break;
                }
                dfs(board, i, j, p, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];   // character in current cell
        if (c == '#' || p.children[c - 'a'] == null) { // found marked char or the char is not in Trie
            return; // backtrack
        }
        p = p.children[c - 'a'];
        if (p.word != null) { // found one word
            res.add(p.word);
            p.word = null;  // de-duplicate
        }

        board[i][j] = '#';  // mark the char as #, saving O(n^2) extra space of marked[][]
        if (i > 0) dfs(board, i - 1, j, p, res); // search up
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); // search down
        if (j > 0) dfs(board, i, j - 1, p, res);    // search left
        if (j < board[0].length - 1) dfs(board, i, j + 1, p ,res);  // search right
        board[i][j] = c;    // backtrack, restore original char
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (Character c : w.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) {
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
