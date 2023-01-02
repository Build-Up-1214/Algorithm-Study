# DFS
import sys
sys.setrecursionlimit(10**6) # 재귀 제한 크기 변경
input = sys.stdin.readline

N, M = map(int, input().split()) # 정점의 개수, 간선의 개수
graph = [[] for _ in range(N + 1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)
def dfs(node):
    visited[node] = True
    
    for i in graph[node]: # 연결된 정점들 중 방문하지 않은 정점이 있다면 dfs 탐색
        if not visited[i]:
            dfs(i)

count = 0
for i in range(1, len(graph)): # 이중 for문을 통해 모든 정점에 접근
    if not visited[i]: # 방문하지 않은 정점이 있을 경우 dfs 탐색하고, count + 1
        dfs(i)
        count += 1

print(count)