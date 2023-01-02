import sys
from collections import deque

input = sys.stdin.readline

N, M, V = map(int, input().split()) # 정점 개수, 간선 개수, 탐색 시작 정점

dfs_visited = [False] * (N + 1)
bfs_visited = [False] * (N + 1)

graph = [[0] * (N + 1) for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

def dfs(v):
    dfs_visited[v] = True
    print(v, end = " ")
    
    for i in range(1, N + 1):
        if not dfs_visited[i] and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    bfs_visited[v] = True
    
    queue = deque()
    queue.append(v)
    
    while queue:
        popV = queue.popleft()
        print(popV, end = " ")
        
        for i in range(1, N + 1):
            if not bfs_visited[i] and graph[popV][i] == 1:
                queue.append(i)
                bfs_visited[i] = True
                
dfs(V)
print()
bfs(V)