import sys

input = sys.stdin.readline

# 정수 입력 받기
num = int(input())

if num == 1:
    print(1)
else:
    dp = [0, 1, 3]
    for i in range(3, num + 1):
        dp.append((dp[i - 1] + dp[i - 2] * 2) % 10007)
    print(dp[num])
