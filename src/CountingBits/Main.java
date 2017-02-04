package CountingBits;

import java.util.Arrays;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
        for (int i : countBits2(10)) {
            System.out.print(i + " ");
        }
    }

    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        bits[0] = 0;
        if (num >= 1) {
            bits[1] = 1;
        }
        for (int i = 2; i <= num; i++) {
            Double x = Math.log(i) / Math.log(2);
            if (x - x.intValue() <= 0.0000000001) {
                bits[i] = 1;
            } else {
                int p = x.intValue();
                bits[i] = bits[1 << p] + bits[i - (1 << p)];
            }
        }
        return bits;
    }

    public static int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
