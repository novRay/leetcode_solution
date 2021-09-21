import java.util.LinkedList;
import java.util.List;

// Queue
public class Solution2 {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        int n = digits.length();
        if (n < 1) {
            return res;
        }
        String[] phoneMap = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        res.add("");
        for (int i = 0; i < n; i++) {
            String letters = phoneMap[digits.charAt(i) - '0'];
            int margin = res.size();
            for (int j = 0; j < margin; j++) {
                String pre = res.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    res.add(pre + letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> t = letterCombinations("23");
        for (String s : t) {
            System.out.println(s);
        }
    }
}
