n, m = map(int, input().split()) # 배열의 크기
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        # 본래값 + 왼쪽 + 위쪽 - 대각선
        dp[i][j] = arr[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]

k = int(input()) # 합을 구할 부분의 개수
for i in range(k):
    i, j, x, y = map(int, input().split())
    # dp[i - 1][y] - dp[x][j - 1]에서 겹치는 부분을 더해 준다
    print(dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1])