package SingleNumber;

/**
 * Created by xhaiben on 2017/2/6.
 */
public class Main {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 1, 2, 3, 4};
        System.out.println(singleNumber(n));
    }

    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int m : nums) n ^= m;
        return n;
    }
}
