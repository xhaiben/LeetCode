package FindAllNumbersDisappearedInAnArray;

import java.util.*;

/**
 * Created by xhaiben on 2017/2/6.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers2(nums);
    }

    /**
     * 直观解法 使用Set
     * 出现两次的无法插入
     * 找出不在Set中的数
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
        return list;
    }

    /**
     * 相反数解法
     * 正常出现的数都置为负 则正数的Index即为未出现的数
     *  4  3  2  7  8  2  3  1
     * -4 -3 -2 -7  8  2 -3 -1
     *  1  2  3  4  5  6  7  8
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        System.out.println(list);
        return list;
    }
}
