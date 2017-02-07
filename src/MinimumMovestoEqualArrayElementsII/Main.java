package MinimumMovestoEqualArrayElementsII;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xhaiben on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(minMoves22(nums));
    }

    /**
     * 排序后
     * 取中位数 遍历相加 O(n)
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int min = nums[nums.length / 2];
        int count = 0;
        for (int n : nums) {
            count += Math.abs(n - min);
        }
        return count;
    }

    /**
     * 排序后，计算两边之差
     * 求差和 O(n/2)
     *
     * @param nums
     * @return
     */
    static int minMoves22(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j--] - nums[i++];
        }
        return count;
    }
}
