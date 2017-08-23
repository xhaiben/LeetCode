package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (List<String> list : partition("aba")) {
            System.out.println(list);
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        dfs(s, 0, result, list);
        return result;
    }

    private static void dfs(String s, int pos, List<List<String>> result, List<String> list) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String subStr = s.substring(pos, i);
            if (!isPalindrome(subStr.toCharArray())) {
                continue;
            }
            list.add(subStr);
            dfs(s, i, result, list);
            list.remove(list.size() - 1);
        }

    }

    private static boolean isPalindrome(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }
}
