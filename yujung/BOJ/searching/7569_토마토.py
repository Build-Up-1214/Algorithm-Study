# 최단거리: BFS
import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split()) # 가로, 세로, 상자 수
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]

dx = [0, 0, -1, 1, 0, 0] # 상, 하, 좌, 우, 앞, 뒤
dy = [1, -1, 0, 0, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

queue = deque()
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 1:
                queue.append((i, j, k)) # 익은 토마토일 경우 Queue에 넣는다

def bfs():
    while queue: # Queue에 데이터가 존재한다면 반복
        z, y, x = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            
            if nx < 0 or nx >= M or ny < 0 or ny >= N or nz < 0 or nz >= H: # 좌표가 상자를 벗어나면 다음 반복으로 넘어감
                continue
            
            if box[nz][ny][nx] == 0 and not visited[nz][ny][nx]: # 익지 않은 토마토가 있고, 방문하지 않은 좌표일 경우
                visited[nz][ny][nx] = True # 방문 처리
                box[nz][ny][nx] = box[z][y][x] + 1 # 지나온 좌표 수 누적
                queue.append((nz, ny, nx)) # Queue에 해당 좌표 넣기

bfs()

tomato_max = 0
for i in box:
    for j in i:
        for k in j:
            if k == 0:
                print(-1) # 익지 않은 토마토가 있으면 -1 반환
                exit(0)
        tomato_max = max(tomato_max, max(j))

print(tomato_max - 1) # 시작 좌표의 값이 1이었으므로 -1