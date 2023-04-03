# BFS
from collections import deque

f, s, g, u, d = map(int, input().split()) # 건물의 총 층 수, 현재 층, 목적지, Up, Down
visited = [-1] * (f + 1) # 방문 체크

queue = deque()
queue.append(s)
visited[s] = 0 # 방문 횟수

while queue:
    now = queue.popleft()
    
    # UP: 위로 이동할 때 총 층 수를 넘어가지 않고, 아직 방문하지 않은 경우 방문 루트에 포함
    if now + u <= f and visited[now + u] == -1:
        visited[now + u] = visited[now] + 1
        queue.append(now + u)
    
    # DOWN
    if now - d >= 1 and visited[now - d] == -1:
        visited[now - d] = visited[now] + 1
        queue.append(now - d)

if visited[g] == -1:
    print("use the stairs")
else:
    print(visited[g])