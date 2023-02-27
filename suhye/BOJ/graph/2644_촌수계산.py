import sys

n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

visit = [0]*(n+1)
res = [0]*(n+1)

def dfs(a):
    visit[a] = 1
    for i in graph[a]:
        if visit[i] == 0:
            res[i] = res[a] + 1
            dfs(i)
dfs(a)
if res[b] == 0:
    print(-1)
else:
    print(res[b])
