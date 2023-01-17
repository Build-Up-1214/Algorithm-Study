import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().rstrip().split()))

# dp : data[i]를 마지막 원소로 가질 때, 증가하는 부분 수열의 길이
dp = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if data[i] < data[j]:
            dp[i] = max(dp[j] + 1, dp[i])

print(max(dp))