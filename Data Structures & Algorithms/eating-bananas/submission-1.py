class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        right = max(piles)
        left = 1
        smallest = right
        while left <= right:
            mid = left + (right - left) // 2
            if self.checkSolution(piles, h, mid):
                smallest = mid
                right = mid - 1
            else:
                left = mid + 1
        return smallest

    def checkSolution(self, piles: List[int], h: int, k: int) -> bool:
        hours = 0
        for pile in piles:
            hours += math.ceil(float(pile) / k) 
        return hours <= h


        
        