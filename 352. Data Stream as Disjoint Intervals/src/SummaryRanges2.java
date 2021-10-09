import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges2 {
    TreeMap<Integer, Integer> treeMap;
    public SummaryRanges2() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer floor = treeMap.floorKey(val);
        if (floor != null && treeMap.get(floor) >= val){
            return;
        }
        Integer ceiling = treeMap.ceilingKey(val);
        if (ceiling != null && ceiling == val + 1) {
            treeMap.put(val, treeMap.get(ceiling));
            treeMap.remove(ceiling);
        } else {
            treeMap.put(val, val);
        }
        if (floor != null && treeMap.get(floor) == val - 1) {
            treeMap.put(floor, treeMap.get(val));
            treeMap.remove(val);
        }
    }

    public int[][] getIntervals() {
        int n = treeMap.size();
        int[][] res = new int[n][2];
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            res[cnt][0] = entry.getKey();
            res[cnt++][1] = entry.getValue();
        }
        return res;
    }
}
