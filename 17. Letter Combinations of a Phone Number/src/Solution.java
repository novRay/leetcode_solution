import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Backtrack
public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        int n = digits.length();
        if (n < 1) {
            return res;
        }
        Map<Character, String> phoneMap = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        backtrack(res, phoneMap, new StringBuilder(), digits, 0);
        return res;
    }

    private static void backtrack(List<String> res, Map<Character, String> map, StringBuilder cmb,
                           String digits, int index) {
        if (index == digits.length()) {
            res.add(cmb.toString());
        } else {
            char c = digits.charAt(index);
            String letters = map.get(c);
            for (int i = 0; i < letters.length(); i++) {
                cmb.append(letters.charAt(i));
                backtrack(res, map, cmb, digits, index + 1);
                cmb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> t = letterCombinations("23");
        for (String s : t) {
            System.out.println(s);
        }
    }
}
