import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

# DFS 정의
def dfs(y, x):
    # 상하좌우 이동하여 계산하기 위한 list
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]

    # 상, 하, 좌, 우 확인
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= ny < n) and (0 <= nx < m):
            if graph[ny][nx] == 1:
                graph[ny][nx] = -1    # 배추가 인접할 때 체크
                dfs(ny, nx)



T = int(input())
for _ in range(T):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]    # 배추밭과 동일한 행렬 생성
    cnt = 0

    # 행렬 생성
    for _ in range(k):
        a, b = map(int, input().split())
        graph[b][a] = 1    # 배추 위치 표시

    for i in range(n):    # 행 (바깥 리스트)
        for j in range(m):    # 열 (내부 리스트)
            if graph[i][j] > 0:
                dfs(i, j)
                cnt += 1
    print(cnt)
