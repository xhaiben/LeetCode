class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def __init__(self):
        self.cur_sum = 0

    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.in_in_order(root)
        return root

    def in_in_order(self, root):
        if root is None:
            return
        self.in_in_order(root.right)
        root.val += self.cur_sum
        self.cur_sum = root.val
        self.in_in_order(root.left)


solution = Solution()
root = TreeNode(5)
root.left = TreeNode(2)
root.right = TreeNode(13)

solution.convertBST(root)
