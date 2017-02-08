package InvertBinaryTree;

import java.util.Scanner;

/**
 * Created by xhaiben on 2017/2/8.
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
    private static int i = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] data = {4, 2, 1, 3, 7, 6, 9, 0};
        TreeNode root = buildTree(null);
        inO(root);
        invertTree(root);
        System.out.println();
        inO(root);
    }

    public static TreeNode buildTree(TreeNode node) {
        int data = scanner.nextInt();
        if (data != 0) {
            node = new TreeNode(data);
            node.left = buildTree(node.left);
            node.right = buildTree(node.right);
        } else {
            node = null;
        }
        return node;
    }

    public static TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    public static void inO(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        inO(node.left);
        inO(node.right);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }
}
