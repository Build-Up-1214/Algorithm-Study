import sys
input = sys.stdin.readline

# 계단의 개수 입력 받기
n = int(input())
data = [0] * n

# 각 계단의 점수 입력받기
for i in range(n):
    data[i] = int(input())

# 점수의 합을 저장하는 리스트
dp = [0 for _ in range(n)]

# 계단의 개수가 2개 이하일 경우 그냥 다 더해서 출력
if n < 3:
    print(sum(data))

else:
    dp[0] = data[0]    # 첫 번째 계단 수동 계산
    dp[1] = data[0] + data[1]    # 두 번째 계단 수동 계산
    dp[2] = max(data[1] + data[2], data[0] + data[2])    # 세 번째 계단 수동 계산
    for i in range(3, n):    # 네 번째 계산부터 dp 점화식을 이용하여 최댓값 구하기
        # 마지막 계단은 반드시 밟아야하므로 마지막 계단의 전 계단을 밟은 경우와 밟지 않은 경우로 구분
        dp[i] = max(dp[i - 3] + data[i - 1] + data[i], dp[i - 2] + data[i])

    print(dp[n-1])