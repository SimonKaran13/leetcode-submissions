class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # 1. Find row
        leftRow = 0
        rightRow = len(matrix) - 1
        while (leftRow <= rightRow):
            midRow = leftRow + (rightRow - leftRow) // 2
            if target >= matrix[midRow][0] and target <= matrix[midRow][-1]:
                # 2. Find element in Row
                return self.binarySearch(matrix[midRow], target)
            elif target < matrix[midRow][0]:
                rightRow = midRow - 1
            else:
                leftRow = midRow + 1
        
        # No element found
        return False

    def binarySearch(self, row: List[int], target: int) -> bool:
        left = 0
        right = len(row) - 1
        while (left <= right):
            mid = left + (right - left) // 2
            print(mid)
            if row[mid] == target:
                return True
            elif target < row[mid]:
                right = mid - 1
            else:
                left = mid + 1
        
        return False
        