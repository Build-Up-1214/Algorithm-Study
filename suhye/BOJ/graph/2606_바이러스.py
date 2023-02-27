import sys

n = int(sys.stdin.readline())
pair = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]

for _ in range(pair):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visit = [0] * (n + 1)

cnt = 0


def dfs(start):
    global cnt
    visit[start] = 1
    for i in graph[start]:
        if visit[i] == 0:
            cnt += 1
            dfs(i)

dfs(1)
print(cnt)
