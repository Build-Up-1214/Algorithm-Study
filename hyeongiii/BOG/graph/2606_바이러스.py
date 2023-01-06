import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[False] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().rstrip().split())
    graph[a][b] = graph[b][a] = True

visited = [False] * (n + 1)
com = []


def dfs(node):
    visited[node] = True
    com.append(node)
    for i in range(1, n + 1):
        if not visited[i] and graph[node][i]:
            dfs(i)


dfs(1)
print(len(com) - 1)