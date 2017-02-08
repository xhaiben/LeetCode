package RelativeRanks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhaiben on 2017/2/8.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 4, 1, 3, 2};
        Arrays.stream(findRelativeRanks2(nums)).forEach(s -> System.out.println(s));
    }

    public static String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for (int i = nums.length - 1, j = 1; i >= 0; i--, j++) {
            map.put(nums[i], j);
        }
        return Arrays.stream(nums2).mapToObj(n -> {
            switch (map.get(n)) {
                case 1:
                    return "Gold Medal";
                case 2:
                    return "Silver Medal";
                case 3:
                    return "Bronze Medal";
                default:
                    return String.valueOf(map.get(n));
            }
        }).toArray(String[]::new);
    }

    public static String[] findRelativeRanks2(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, ((o1, o2) -> nums[o2] - nums[o1]));
        String[] ret = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ret[index[i]] = "Gold Medal";
            } else if (i == 1) {
                ret[index[i]] = "Silver Medal";
            } else if (i == 2) {
                ret[index[i]] = "Bronze Medal";
            } else {
                ret[index[i]] = String.valueOf(i + 1);
            }

        }
        return ret;
    }
}
