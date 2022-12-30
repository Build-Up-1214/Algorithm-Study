# 최단거리: BFS
from collections import deque

def bfs(node):
    queue = deque()
    queue.append(node)
    
    while queue:
        node = queue.popleft()
        
        for i in family[node]:
            if visited[i] == 0:
                visited[i] = visited[node] + 1
                queue.append(i)

n = int(input()) # 전체 사람 수
family = [[] for _ in range(n + 1)]

a, b = map(int, input().split())

m = int(input()) # 관계의 개수
for i in range(m):
    p, c = map(int, input().split())
    family[p].append(c)
    family[c].append(p)

visited = [0] * (n + 1)

bfs(a)

print(visited[b] if visited[b] > 0 else -1)