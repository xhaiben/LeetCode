package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {

    public static void main(String[] args) {

    }

    public static List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    private static List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = buildTree(start, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, end);
            for (TreeNode treeNode : leftTree) {
                for (TreeNode node : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = node;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
