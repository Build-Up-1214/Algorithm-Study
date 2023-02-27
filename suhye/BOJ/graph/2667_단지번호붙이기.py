import sys
from collections import deque

n = int(sys.stdin.readline())

graph = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

ans = []
visit = [[0] * n for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    graph[x][y] = 0  # 방문한 곳은 0으로 바꿔 다시 방문하지 않도록 한다.
    cnt = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                q.append((nx, ny))
                cnt += 1

    return cnt

def dfs(x,y):
    global cnt
    cnt += 1
    graph[x][y] = 0  # 방문한 곳은 0으로 바꿔 다시 방문하지 않도록 한다.
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1:
            dfs(nx,ny)


cnt_list = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            cnt = 0
            dfs(i,j)
            cnt_list.append(cnt)
#             cnt_list.append(bfs(i, j))

cnt_list.sort()
print(len(cnt_list))
for c in cnt_list:
    print(c)
