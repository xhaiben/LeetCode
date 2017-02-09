package TwoSumII;

import java.util.Arrays;

/**
 * Created by xhaiben on 2017/2/9.
 */
public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        twoSum(numbers, target);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] ret = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ret[0] = left + 1;
                ret[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        Arrays.stream(ret).forEach(value -> System.out.println(value));
        return ret;
    }
}
