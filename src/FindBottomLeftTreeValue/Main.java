package FindBottomLeftTreeValue;

/**
 * Created by xhaiben on 2017/2/21.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    private static int depth = 0;
    private static int h = 0;
    private static int ret = 0;

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ret;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if (depth > h) {
            ret = root.val;
            h = depth;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }

}
