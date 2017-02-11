package MinimumMovestoEqualArrayElements;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by xhaiben on 2017/2/11.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2147483647};
        System.out.println(minMoves3(nums));
    }

    /**
     * 算法超时
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (nums[0] != nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] += 1;
            }
            Arrays.sort(nums);
            count++;
        }
        return count;
    }

    /**
     * 把其他所有元素加一，相当于把一个元素减一
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }

    /**
     * 一行算法
     * 看起来很酷，但是效率不高
     * @param nums
     * @return
     */
    public static int minMoves3(int[] nums) {
        return IntStream.of(nums).sum() - IntStream.of(nums).min().getAsInt() * nums.length;
    }
}
