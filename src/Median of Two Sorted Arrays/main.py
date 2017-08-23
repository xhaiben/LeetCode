class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1, len2 = len(nums1), len(nums2)
        index = (len1 + len2) / 2
        nums = nums1 + nums2
        nums.sort()
        if (len1 + len2) & 1 == 1:
            return nums[index]
        else:
            return (nums[index] + nums[index - 1]) / 2.0


solution = Solution()
nums1 = []
nums2 = [2, 3]
print solution.findMedianSortedArrays(nums1, nums2)
