package PermutationsII;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        List<List<Integer>> ret = permuteUnique(nums);
        for (List<Integer> integers : ret) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Boolean[] visited = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i] = false;
        }
        dfs(nums, visited, result, list);
        return result;
    }

    public static void dfs(int[] nums, Boolean[] visited, List<List<Integer>> ret, List<Integer> list) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, ret, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
