# 정수 입력받기
num = int(input())

# DP 테이블 초기화
dp = [0, 1]

# 다이나믹 프로그래밍 진행 (BottomUp)
for i in range(2, num + 1):
    dp.append(dp[i - 1] + dp[i - 2])

print(dp[num])