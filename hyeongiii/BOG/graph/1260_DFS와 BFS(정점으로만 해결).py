from collections import deque

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)


# DFS
def dfs(node):
    visited_dfs[node] = True
    print(node, end=" ")

    for i in graph[node]:
        if not visited_dfs[i]:
            dfs(i)


def bfs(node):
    q = deque()
    q.append(node)
    visited_bfs[node] = True

    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited_bfs[i]:
                visited_bfs[i] = True
                q.append(i)


for i in graph:
    i.sort()

dfs(v)
print()
bfs(v)
