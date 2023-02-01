import sys
input = sys.stdin.readline

n = int(input())
# x: 행(세로), y: 열(가로)
x, y = 1, 1
commands = input().split()

# L, R, U, D 에 따른 이동 방향
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
moves_type = ['L', 'R', 'U', 'D']

# 명령을 하나씩 확인
for c in commands:
    # 이동 후 좌표 확인
    for i in range(len(moves_type)):
        if c == moves_type[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    # 공간을 벗어날 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    # 이동 수행
    x, y = nx, ny

print(x, y)