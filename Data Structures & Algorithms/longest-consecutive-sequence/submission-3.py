class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest_sequence = 0

        for n in nums:
            # Check if it's start of sequence
            if n - 1 not in num_set:
                sequence_length = 0
                while n + sequence_length in num_set:
                    sequence_length += 1
                longest_sequence = max(longest_sequence, sequence_length)

        return longest_sequence


        