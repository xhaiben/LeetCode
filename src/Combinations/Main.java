package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (List<Integer> list : combine(4, 2)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (n < k) {
            return result;
        }
        dfs(n, k, 1, list, result);
        return result;
    }

    public static void dfs(int n, int k, int p, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = p; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
