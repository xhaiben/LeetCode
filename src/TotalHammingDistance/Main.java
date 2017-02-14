package TotalHammingDistance;

/**
 * Created by xhaiben on 2017/2/14.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance2(nums));
    }

    /**
     * 循环相加 超时
     *
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                n += hammingDistance(nums[i], nums[j]);
            }
        }
        return n;
    }

    public static int hammingDistance(int a, int b) {
        int x = a ^ b;
        int count = 0;
        while (x != 0) {
            count++;
            x &= (x - 1);
        }
        return count;
    }

    public static int totalHammingDistance2(int[] nums) {
        int n = 0;
        int length = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 0) {
                    count++;
                }
            }
            n += count * (length - count);
        }
        return n;
    }
}
