class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        count = 0
        prevEnd = intervals[0][1]
        for interval in intervals[1:]:
            if prevEnd > interval[0]:
                count = count + 1
                prevEnd = min(prevEnd, interval[1])
            else:
                prevEnd = interval[1]

        return count
        