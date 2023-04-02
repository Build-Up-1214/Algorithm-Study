import sys

n = int(sys.stdin.readline())

nums = list(map(int, sys.stdin.readline().split()))

sums = [0]*n
sums[0] = nums[0]
for i in range(1, n):
    sums[i] = max(nums[i], sums[i-1]+nums[i])

print(max(sums))