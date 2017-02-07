package AddDigits;

/**
 * Created by xhaiben on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    /**
     * 尾递归算法
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return add(num, 0);
    }

    static int add(int num, int num2) {
        if (num == 0) {
            return num2;
        }
        num = num + num2;
        return add(num / 10, num % 10);
    }

    /**
     * O(1)
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        return 1 + (num - 1) % 9;
    }
}
