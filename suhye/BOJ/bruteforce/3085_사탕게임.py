import sys

n = int(sys.stdin.readline())
candies = [list(sys.stdin.readline()) for _ in range(n)]

def count(candies):
    maxCnt = 1
    for i in range(n):
        rowCnt = 1
        colCnt = 1
        for j in range(1, n):
            # 가로로 가장 긴 것
            if candies[i][j] == candies[i][j - 1]:
                rowCnt += 1
                maxCnt = max(maxCnt, rowCnt)
            else:
                rowCnt = 1

            # 세로로 가장 긴 것
            if candies[j][i] == candies[j - 1][i]:
                colCnt += 1
                maxCnt = max(maxCnt, colCnt)
            else:
                colCnt = 1
    return maxCnt


ans = 0
for i in range(n):
    for j in range(n):
        # 가로로 바꾸기
        if j + 1 < n:
            candies[i][j], candies[i][j + 1] = candies[i][j + 1], candies[i][j]
            ans = max(ans, count(candies))
            candies[i][j], candies[i][j + 1] = candies[i][j + 1], candies[i][j]  # 원위치
        # 세로로 바꾸기
        if i + 1 < n:
            candies[i][j], candies[i + 1][j] = candies[i + 1][j], candies[i][j]
            ans = max(ans, count(candies))
            candies[i][j], candies[i + 1][j] = candies[i + 1][j], candies[i][j]  # 원위치

print(ans)
