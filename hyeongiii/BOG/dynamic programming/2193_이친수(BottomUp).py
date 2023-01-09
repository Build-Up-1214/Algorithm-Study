# 정수 입력받기
num = int(input())

# DP 테이블 초기화
if num == 1:    # num이 1일 경우
    dp = [0] * 2
    dp[1] = 1
else:    # num이 1이 아닐 경우
    dp = [0] * (num + 1)
    dp[1] = dp[2] = 1

# 다이나믹 프로그래밍 진행 (BottomUp)
for i in range(3, num + 1):
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[num])