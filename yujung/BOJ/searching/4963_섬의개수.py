from collections import deque

dx = [0, 0, -1, 1, -1, -1, 1, 1] # 상하좌우대각선
dy = [1, -1, 0, 0, -1, 1, 1, -1]

def bfs(x, y, w, h):
    q = deque()
    q.append((x, y)) # 탐색을 시작할 섬의 좌표
    island[x][y] = 2 # 방문 시 2로 값 변경
    
    while q: # Queue가 빌 때까지 반복 = 더 이상 이어진 섬이 없을 때까지
        cx, cy = q.popleft() # 섬의 좌표
        for i in range(8): # 상하좌우대각선탐색
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < h and 0 <= ny < w and island[nx][ny] == 1: # 지도를 벗어나지 않았고, 섬인 경우
                island[nx][ny] = 2 # 방문 표시
                q.append((nx, ny)) # Queue에 넣기
    return 1

while True:
    w, h = map(int, input().split()) # 지도의 너비, 높이
    if w == 0 and h == 0:
        exit(0)
    island = [list(map(int, input().split())) for _ in range(h)]
    
    answer = 0 # 섬의 개수
    for i in range(h):
        for j in range(w):
            if island[i][j] == 1:
                answer += bfs(i, j, w, h)
    print(answer)