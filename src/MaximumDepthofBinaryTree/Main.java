package MaximumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhaiben on 2017/2/6.
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
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {

        return 0;
    }

    /**
     * 计算二叉树深度
     *
     * @param treeNode
     * @return
     */
    static int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(depth(treeNode.left), depth(treeNode.right));
    }

    /**
     * 计算二叉树结点个数
     *
     * @param treeNode
     * @return
     */
    static int treeSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + treeSize(treeNode.left) + treeSize(treeNode.right);
    }

    /**
     * 深度优先的中序遍历
     *
     * @param subTree
     */
    public static void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.left);
            System.out.println(subTree.val);
            inOrder(subTree.right);
        }
    }

    /**
     * 深度优先的前序遍历
     *
     * @param treeNode
     */
    static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    /**
     * 深度优先的后序遍历
     *
     * @param treeNode
     */
    static void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            preOrder(treeNode.left);
            preOrder(treeNode.right);
            System.out.println(treeNode.val);
        }
    }

    /**
     * 广度优先遍历 基于队列
     * @param treeNode
     */
    static void levelOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(treeNode);
        while (!treeNodeQueue.isEmpty()) {
            treeNode = treeNodeQueue.poll();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                treeNodeQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodeQueue.add(treeNode.right);
            }
        }
    }
}
