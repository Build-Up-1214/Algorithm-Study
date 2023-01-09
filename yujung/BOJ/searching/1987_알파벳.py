# BFS
def bfs(m):
    cnt = 1
    q = set() # deque로 풀이하면 중복 문제로 인해 시간 초과 발생
    q.add((0, 0, m[0][0]))
    
    while q:
        x, y, road = q.pop()
        cnt = max(cnt, len(road)) # 새 경로 있으면 업데이트
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < R and 0 <= ny < C and m[nx][ny] not in road: # 지나온 경로인지 확인
                q.add((nx, ny, road + m[nx][ny]))
                
    print(cnt)
                

R, C = map(int, input().split())
matrix = [list(input().rstrip()) for _ in range(R)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

bfs(matrix)