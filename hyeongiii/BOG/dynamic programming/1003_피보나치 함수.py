import sys

input = sys.stdin.readline

# 테스트 케이스 개수 입력 받기
T = int(input())


def rec(n):
    # n이 0일 경우, 0 반환
    if n == 0:
        return 0
    # n이 1일 경우, 1 반환
    if n == 1:
        return 1
    # 이미 계산한 적이 있는 문제라면, 해당 값 그대로 반환
    if dp[n] != -1:
        return dp[n]

    # 아직 계산하지 않은 문제라면, DP(Top Down) 적용
    dp[n] = rec(n - 1) + rec(n - 2)

    return dp[n]


for _ in range(T):
    # 각 테스트 케이스에 해당하는 정수 입력 받기
    num = int(input())
    # 메모이제이션을 위한 리스트 선언
    if num == 0:
        print(1, 0)
        continue
    else:
        dp = [-1] * (num + 1)
        dp[0] = 0
        dp[1] = 1

    # 출력
    print(rec(num - 1), rec(num))
