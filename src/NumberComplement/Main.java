package NumberComplement;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(findComplement(5));
        System.out.println(findComplement2(5));
    }

    /**
     * 各位异或
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        if (num == 0) {
            return ~0;
        }
        int count = 0;
        int num2 = num;
        while (num != 0) {
            num2 ^= 1 << count;
            num >>= 1;
            count++;
        }
        return num2;
    }

    /**
     * 先求掩码
     * 5        0000 0101
     * mask     1111 1000
     * ~mask    0000 0111
     * 5^~mask  0000 0010
     *
     * @param num
     * @return
     */
    public static int findComplement2(int num) {
        //各位全1
        int mask = -1;
        while ((mask & num) != 0)
            mask <<= 1;
        return num ^ ~mask;
    }
}
