package HammingDistance;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Solution {
    /**
     * hamming Distance 两个字符串不同字符的个数
     * 100110
     * 110111
     * 不同的字符有2个
     * 所以其hamming Distance为2
     * 采用异或 将不同的位置为1 统计1的个数
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z >>= 1;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count++;
            z &= (z - 1);
        }
        return count;
    }
}
