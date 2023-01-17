# 수 입력받기
x = int(input())

# DP 딕셔너리 초기화 (dp가 1일 때, 연산횟수 0회)
dp = {1: 0}

# 재귀 사용 (탑다운 방식)
def cal(n):
    if n in dp.keys():
        return dp[n]
    if (n % 3 == 0) and (n % 2 == 0):
        dp[n] = min(cal(n // 3) + 1, cal(n // 2) + 1)
    elif n % 3 == 0:
        dp[n] = min(cal(n // 3) + 1, cal(n - 1) + 1)
    elif n % 2 == 0:
        dp[n] = min(cal(n // 2) + 1, cal(n - 1) + 1)
    else:
        dp[n] = cal(n - 1) + 1

    return dp[n]

print(cal(x))

