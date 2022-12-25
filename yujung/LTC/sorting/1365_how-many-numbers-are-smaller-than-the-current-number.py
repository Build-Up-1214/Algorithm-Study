class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        
        answer = [0] * len(nums)
        sort_nums = sorted(nums)
        
        for i in range(len(nums)):
            answer[i] = sort_nums.index(nums[i])
        
        return answer