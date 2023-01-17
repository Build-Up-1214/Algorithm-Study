import sys
input = sys.stdin.readline

# 테스트 케이스 개수 입력받기
T = int(input())

for _ in range(T):
    # 테스트 케이스 정수 입력받기
    n = int(input())
    # DP 테이블 초기화
    dp= [0, 1, 1, 1, 2, 2, 3]

    # DP 구현 (Bottom Up)
    for i in range(7, n + 1):
        dp.append(dp[i - 1] + dp[i - 5])    # 파도반 수열 P(N) : P(i) = P(i - 1) + P(i - 5)

    print(dp[n])