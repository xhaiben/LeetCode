package MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhaiben on 2017/2/8.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class Main {
    private static int maxCount;
    private static Map<Integer, Integer> sumMap;

    public static void main(String[] args) {

    }

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumMap = new HashMap<>();
        postOrder(root);
        List<Integer> list = new ArrayList<>();
        for (int n : sumMap.keySet()) {
            if (sumMap.get(n) == maxCount) {
                list.add(n);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        int sum = left + right + node.val;
        int count = sumMap.getOrDefault(sum, 0) + 1;
        sumMap.put(sum, count);
        maxCount = Math.max(maxCount, count);
        return sum;
    }

}
