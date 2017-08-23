package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ret = subsets(nums);
        for (List<Integer> integers : ret) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            ret.add(list);
            return ret;
        }
        dfs(nums, 0, list, ret);
        return ret;
    }

    private static void dfs(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        ret.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
