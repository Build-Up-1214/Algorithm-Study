from collections import deque
import copy
import sys
input = sys.stdin.readline

n, m = map(int, input().split()) # 지도의 세로 크기, 가로 크기
room = [list(map(int, input().split())) for _ in range(n)]

def make_wall(c): # 3개의 벽을 세우는 메서드
    if c == 3: # 벽을 모두 세웠을 경우 탐색을 시작한다
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if room[i][j] == 0: # 빈 칸일 경우 벽을 세운다
                room[i][j] = 1
                make_wall(c + 1)
                room[i][j] = 0 # 다음 탐색을 위해 원상복귀

d = [[0, 1], [0, -1], [-1, 0], [1, 0]]
def bfs():
    queue = deque()
    test_room = copy.deepcopy(room) # 각 탐색은 별도의 리스트에서 진행
    
    for i in range(n):
        for j in range(m):
            if test_room[i][j] == 2:
                queue.append((i, j)) # 바이러스가 있는 경우를 모두 Queue에 담는다
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(len(d)):
            nx = x + d[i][0]
            ny = y + d[i][1]
        
            if 0 <= nx < n and 0 <= ny < m: # 빈칸인 경우 바이러스를 전염시키고, 해당 위치를 기준으로 탐색 추가
                if test_room[nx][ny] == 0:
                    test_room[nx][ny] = 2
                    queue.append((nx, ny))
    
    global answer
    count = 0
    for i in range(n):
        for j in range(m):
            if test_room[i][j] == 0: # 빈칸인 경우를 카운트
                count += 1
    answer = max(answer, count)

answer = 0
make_wall(0)
print(answer)