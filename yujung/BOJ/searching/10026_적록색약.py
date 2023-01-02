# BFS
from collections import deque

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    
    while queue:
        visited[x][y] = True
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if matrix[nx][ny] == matrix[x][y] and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))

N = int(input())
matrix = [list(input()) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

# 적록색약이 아닐 경우
cntX = 0
visited = [[False] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j)
            cntX += 1

# 적록색약일 경우
cntO = 0
visited = [[False] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if matrix[i][j] == "R":
            matrix[i][j] = "G"

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j)
            cntO += 1

print(cntX, cntO)