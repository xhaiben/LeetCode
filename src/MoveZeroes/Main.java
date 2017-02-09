package MoveZeroes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xhaiben on 2017/2/9.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 0, 0, 2, 30, 0, 3};
        moveZeroes2(nums);
    }

    /**
     * 重写排序规则，排序，很慢
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        Object[] a = Arrays.stream(nums).boxed().sorted(((o1, o2) -> {
            if (o1 == 0 && o2 == 0) return 0;
            if (o1 == 0) return 1;
            if (o2 == 0) return -1;
            return 1;
        }
        )).toArray();
        for (int i = 0; i < a.length; i++) {
            nums[i] = (Integer) a[i];
            System.out.println(nums[i]);
        }
    }

    /**
     * 将不为0的全部提前，之后的全部置为0
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int position = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[position++] = num;
            }
        }
        while (position < nums.length) {
            nums[position++] = 0;
        }
        Arrays.stream(nums).forEach(num -> System.out.println(num));
    }
}
