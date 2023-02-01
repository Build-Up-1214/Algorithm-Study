import sys
input = sys.stdin.readline

n, m = map(int, input().split())
x, y, d = map(int, input().split())
# 방문한 위치를 저장하기 위한 리스트를 생성하여 0으로 초기화
visit = [[0] * m for _ in range(n)]
visit[x][y] = 1    # 현재 좌표 방문 처리

# 전체 맵 정보 입력받기
data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

# 북, 동, 남, 서 방향 정의
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


# 왼쪽으로 회전
def turn_left():
    global d    # 방향을 나타내는 변수 d 가 함수 바깥에서 선언되었기 때문에, global 로 선언
    d -= 1
    if d == -1:
        d = 3

# 시뮬레이션 시작
cnt = 1
turn_time = 0
while True:
    # 왼쪽으로 회전
    turn_left()
    nx = x + dx[d]
    ny = y + dy[d]
    # 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
    if visit[nx][ny] == 0 and data[nx][ny] == 0:
        visit[nx][ny] = 1
        x = nx
        y = ny
        cnt += 1
        turn_time = 0
        continue
    # 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
    else:
        turn_time += 1
    # 네 방향 모두 갈 수 없는 경우
    if turn_time == 4:
        nx = x - dx[d]
        ny = y - dy[d]
        # 뒤로 갈 수 있다면 이동하기
        if data[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤가 바다로 막혔을 경우
        else:
            break
        turn_time = 0

print(cnt)