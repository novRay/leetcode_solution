import java.util.HashMap;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
            /*
               If a repeated char X is found, move the start pointer to the place when
               X was firstly found.
               Using  Math.max() to make sure start pointer will not go left.
            */
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);    // put the char pointed by end into the map
            res = Math.max(res, end - start + 1);   // update res(the max length of substring)
        }
        return res;
    }

    public static void main(String[] args) {
        int n = lengthOfLongestSubstring("abcadcbb");
        System.out.println(n);
    }
}