class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        n = 0
        for i in range(0, len(nums), 2):
            n += nums[i]
        return n


solution = Solution()
nums = [1, 3, 2, 4]
print solution.arrayPairSum(nums)
