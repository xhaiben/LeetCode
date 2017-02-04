package HammingDistance;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Solution {
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
}
