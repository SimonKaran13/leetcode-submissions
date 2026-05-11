class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # Concept res[i] = prefix_product[i - 1] * postfix_product[i + 1]
        res = [1] * len(nums)

        prefix = 1
        # First calculate the prefixes
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]

        postfix = 1
        # Second calculate the postfixes
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res


        