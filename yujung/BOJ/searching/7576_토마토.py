# 최단거리: BFS
"""
1. 2차원 배열을 만들고, 값이 1인 지점을 Queue에 넣는다
2. 배열 범위 내에서 값이 0인 지점이 있으면 값을 1 증가시키고 Queue에 넣는다
3. Queue가 빌 때까지 1번과 2번 과정을 반복한다
4. 탐색을 마친 후 0인 지점이 존재한다면 -1을 출력하고, 존재하지 않으면 가장 큰 수를 출력한다.
"""
from collections import deque

M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]

queue = deque()
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append([i, j])

dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]

def bfs():
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < M and box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append([nx, ny])

bfs()

tomato_max = 0
for i in box:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    tomato_max = max(tomato_max, max(i))

print(tomato_max - 1) # 탐색을 시작하는 위치의 값이 1이므로 -1