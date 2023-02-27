import sys

board = [list(sys.stdin.readline().split()) for _ in range(5)]
ans = []


def dfs(x, y, number):
    if len(number) == 6:
        if number not in ans:
            ans.append(number)
        return

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= 5 or ny >= 5:
            continue
        else:
            dfs(nx, ny, number + board[nx][ny])


for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j])
print(len(ans))
