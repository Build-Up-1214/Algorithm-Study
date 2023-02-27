import sys

n = int(sys.stdin.readline())
stairs = [0]*301
for i in range(n):
    stairs[i]=int(sys.stdin.readline())

dp = [0] * 301
dp[0] = stairs[0]  # 첫번째 계단
dp[1] = stairs[0] + stairs[1]  # 두번째 계단
dp[2] = max(stairs[0]+stairs[2], stairs[1]+stairs[2])  # 세번째 계단
for i in range(3, n):  # 그 전 계단을 안밟은 경우와, 밟은 경우 중 최댓값
    dp[i] = max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i])
print(dp[n-1])
