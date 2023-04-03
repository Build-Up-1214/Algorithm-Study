import sys
input = sys.stdin.readline

n = int(input()) # 퇴사까지 남은 일수
schedule = [list(map(int, input().split())) for i in range(n)] # [상담 기간, 금액]
dp = [0 for _ in range(n + 1)]

for i in range(n): # i번째 스케줄까지 일했을 때의 수익을 계산
    for j in range(i + schedule[i][0], n + 1): # i번째 스케줄을 처리한 이후 가능한 스케줄
        if dp[j] < dp[i] + schedule[i][1]: # i번째 스케줄을 처리했을 때의 이익 > j번째 스케줄을 처리했을 때의 이익
            dp[j] = dp[i] + schedule[i][1]

print(dp[-1])