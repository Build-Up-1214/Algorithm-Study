# 정수 입력 받기
num = int(input())

# 메모이제이션을 위한 리스트 선언
if num == 1:
    dp = [0] *2
    dp[1] = 1
else:
    dp = [0] * (num + 1)
    dp[1] = dp[2] = 1

# 다이나믹 프로그래밍 구현 (TopDown)
def rec(n):
    # 종료 조건 (1 혹은 2 일 때, 1을 반환)
    if n == 1 or n == 2:
        return 1
    # 이미 계산한 적이 있는 문제라면 그대로 반환
    if dp[n] != 0:
        return dp[n]
    # 아직 계산하지 않은 문제라면 피보나치 결과 반환
    dp[n] = rec(n - 1) + rec(n - 2)

    return dp[n]

print(rec(num))