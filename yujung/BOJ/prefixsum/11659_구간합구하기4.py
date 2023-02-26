import sys
input = sys.stdin.readline

n, m = map(int, input().split()) # 수의 개수, 합을 구해야 하는 횟수
nums = list(map(int, input().split())) # n개의 수
prefix_sum = [0]

temp = 0
for i in nums: # 누적합
    temp += i
    prefix_sum.append(temp)

for i in range(m):
    a, b = map(int, input().split())
    print(prefix_sum[b] - prefix_sum[a - 1])