import sys
input = sys.stdin.readline

# 정수 n 입력 받기
n = int(input())
# 임의의 수열 입력 받기
data = list(map(int, input().rstrip().split()))

# DP 테이블 초기화
dp = [0] * n
dp[0] = data[0]

# DP 구현 (Bottom Up)
for i in range(1, n):
    dp[i] = max(dp[i - 1] + data[i], data[i])    # i번째의 data 값과 i번째 까지 더한 값 중 더 큰 값을 dp 테이블에 저장

print(max(dp))