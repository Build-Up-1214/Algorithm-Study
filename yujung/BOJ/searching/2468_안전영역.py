from collections import deque

n = int(input()) # 2차원 배열의 행과 열의 개수
area = [list(map(int, input().split())) for _ in range(n)]
max_deep = max(map(max, area))
answer = 1

'''
1. for문을 통해 모든 좌표에서 접근
2. 방문하지 않은 좌표가 있을 경우 BFS 탐색 (이때 깊이 검사 후 만족 시 answer + 1)
'''

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(rain):
    r_answer = 0
    visited = [[False] * n for _ in range(n)]
    queue = deque()
    
    for i in range(n):
        for j in range(n):
            if area[i][j] > rain and not visited[i][j]:
                visited[i][j] = True
                queue.append([i, j])
    
                while queue:
                    x, y = queue.popleft()
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        
                        # 영역을 벗어나지 않고, 영역의 깊이가 비의 양보다 더 깊으모 아직 방문하지 않은 영역일 경우
                        if 0 <= nx < n and 0 <= ny < n and area[nx][ny] > rain and not visited[nx][ny]:
                            visited[nx][ny] = True # 방문 처리
                            queue.append([nx, ny]) # 새로운 탐색
                r_answer += 1

    return r_answer

for i in range(1, max_deep + 1): # 1 <= 비의 양 <= 최대 깊이
    answer = max(answer, bfs(i))

print(answer)