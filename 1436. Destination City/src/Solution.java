import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String cityA = path.get(0);
            String cityB = path.get(1);
            map.put(cityA, 0);
            if (!map.containsKey(cityB)) {
                map.put(cityB, 1);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                return s;
            }
        }
        return null;
    }
}
