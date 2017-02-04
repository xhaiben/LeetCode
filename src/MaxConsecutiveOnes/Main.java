package MaxConsecutiveOnes;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 0) count = 0;
            else count++;
            max = max > count ? max : count;
        }
        return max;
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                max = max > count ? max : count;
                count = 0;
                continue;
            } else {
                count++;
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}
