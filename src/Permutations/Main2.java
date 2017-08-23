package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = permute(nums);
        for (List<Integer> integers : ret) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 1) {
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int[] numsNew = new int[nums.length - 1];
            System.arraycopy(nums, 0, numsNew, 0, i);
            System.arraycopy(nums, i + 1, numsNew, i, numsNew.length - i);
            List<List<Integer>> retTmp = permute(numsNew);
            for (List<Integer> integers : retTmp) {
                integers.add(nums[i]);
                result.add(integers);
            }
        }
        return result;
    }
}
