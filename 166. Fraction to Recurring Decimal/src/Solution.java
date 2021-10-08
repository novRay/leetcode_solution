import java.util.*;

public class Solution {
    public String fractionToDecimal(int _numerator, int _denominator) {
        long numerator = _numerator;
        long denominator = _denominator;
        if (numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        // Integral part
        sb.append(numerator / denominator);
        numerator %= denominator;
        if (numerator == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }

        // fractional part
        Map<Long, Integer> map = new HashMap<>();
        map.put(numerator, sb.length());
        while (numerator != 0) {
            numerator *= 10;
            sb.append(numerator / denominator);
            long remainder = numerator % denominator;
            if (map.containsKey(remainder)) {
                int remainderIndex = map.get(remainder);
                sb.insert(remainderIndex, "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            numerator = remainder;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.fractionToDecimal(1, 6);
    }
}
