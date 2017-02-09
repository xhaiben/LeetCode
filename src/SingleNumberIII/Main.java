package SingleNumberIII;

import java.util.Arrays;

/**
 * Created by xhaiben on 2017/2/9.
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 3, 2, 5};
        singleNumber(ints);
    }

    public static int[] singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        n &= -n;
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & n) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }
        Arrays.stream(ret).forEach(value -> System.out.println(value));
        return ret;
    }
}

