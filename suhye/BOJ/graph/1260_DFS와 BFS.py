import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())

graph = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = 1

visit_dfs = [False] * (n + 1)
visit_bfs = [False] * (n + 1)


def dfs(v):
    print(v, end=" ")
    visit_dfs[v] = True
    for i in range(1, n + 1):
        if visit_dfs[i] == False and graph[i][v] == 1:
            dfs(i)


def bfs(v):
    q = deque()
    q.append(v)
    visit_bfs[v] = True
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, n + 1):
            if visit_bfs[i] == False and graph[i][v] == 1:
                q.append(i)
                visit_bfs[i] = True

dfs(v)
print()
bfs(v)