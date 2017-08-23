package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> ret = permute(nums);
        for (List<Integer> integers : ret) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int[] perm = Arrays.copyOf(nums, nums.length);
        Arrays.sort(perm);

        while (true) {
            List<Integer> list = new ArrayList<>();
            for (int i : perm) {
                list.add(i);
            }
            result.add(list);

            int k = perm.length - 2;
            for (; k >= 0; k--) {
                if (perm[k] < perm[k + 1]) {
                    break;
                }
            }

            if (k == -1) {
                break;
            }

            int r = perm.length - 1;
            while (r > k && perm[r] <= perm[k]) {
                r--;
            }

            int temp = perm[k];
            perm[k] = perm[r];
            perm[r] = temp;

            reverse(perm, k + 1, perm.length - 1);
        }
        return result;
    }

    private static void reverse(int[] nums, int lb, int rb) {
        for (int i = lb, j = rb; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
