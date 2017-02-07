package FindAllDuplicatesinanArray;

import java.util.*;

/**
 * Created by xhaiben on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(findDuplicates2(nums));
    }

    /**
     * 垃圾算法 超级慢
     *
     * @param nums
     * @return
     */
    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> integers = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                integers.add(n);
            } else {
                set.add(n);
            }
        }
        return integers;
    }

    /**
     * 做法类似于 Find All Numbers Disappeared in an Array
     * 用数组的内容做下标，置为负
     * 如果已经为负，则为重复出现的数
     * @param nums
     * @return
     */
    static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) list.add(index + 1);
            else nums[index] = -nums[index];
        }
        return list;
    }
}
