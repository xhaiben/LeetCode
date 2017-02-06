package SumofTwoIntegers;

/**
 * Created by xhaiben on 2017/2/6.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getSum2(1,2));
    }

    /**
     * 循环解法
     * a&b 产生进位信息
     * a^b 产生无进位加
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        do {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        } while (b != 0);
        System.out.println(a);
        return 0;
    }

    /**
     * 递归解法
     * @param a
     * @param b
     * @return
     */
    static int getSum2(int a, int b) {
        return b == 0 ? a : getSum2(a ^ b, (a & b) << 1);
    }
}
