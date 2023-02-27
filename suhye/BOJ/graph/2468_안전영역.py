import sys
from collections import deque

n = int(sys.stdin.readline())
graph = []
max = 0

for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))
    for j in range(n):
        if graph[i][j] > max:
            max = graph[i][j]

# 높이: 1이상 100 이하

cnt = [0]*101

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x, y, h, visit):
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visit[nx][ny] == 0:
                if graph[nx][ny] > h:
                    visit[nx][ny] = 1
                    q.append((nx, ny))

res = 0
for i in range(max):
    visit = [[0]*n for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if graph[j][k] > i and visit[j][k] == 0:
                bfs(j, k, i, visit)
                cnt += 1
    if res < cnt:
        res = cnt

print(res)