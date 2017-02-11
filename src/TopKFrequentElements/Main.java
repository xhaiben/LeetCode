package TopKFrequentElements;

import java.util.*;

/**
 * Created by xhaiben on 2017/2/11.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(topKFrequent(nums, 1));
    }

    /**
     * 使用 hashMap的做法，效率较低
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[][] mapNum = new int[map.size()][2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            mapNum[i][0] = integer;
            mapNum[i][1] = map.get(integer);
            i++;
        }
        Integer[][] is = new Integer[mapNum.length][2];
        for (int j = 0; j < map.size(); j++) {
            is[j][0] = mapNum[j][0];
            is[j][1] = mapNum[j][1];
        }
        Arrays.sort(is, (o1, o2) -> o2[1] - o1[1]);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            list.add(is[j][0]);
        }
        return list;
    }
}
