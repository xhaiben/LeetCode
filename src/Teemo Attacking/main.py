class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        total_time = 0
        end_time = 0
        for i in timeSeries:
            if i >= end_time:
                total_time += duration
            else:
                total_time += i + duration - end_time

            end_time = i + duration
        return total_time

timeSeries = [1, 2]
duration = 2
solution = Solution()
print solution.findPoisonedDuration(timeSeries, duration)
