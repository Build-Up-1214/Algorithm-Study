n, m = map(int, input().split())
board = [input() for _ in range(n)]
answer = []

for i in range(n - 7): # i와 j는 탐색을 시작하는 보드의 좌표이다 보드의 범위를 넘어가지 않도록 한다
    for j in range(m - 7):
        draw1 = 0
        draw2 = 0
        for a in range(i, i + 8):
            for b in range(j, j + 8):
                if (a + b) % 2 == 0:
                    if board[a][b] == 'W': # W인 경우와 B인 경우 모두 count 하여 더 작은 경우를 비교
                        draw1 += 1
                    if board[a][b] == 'B':
                        draw2 += 1
                else:
                    if board[a][b] == 'B':
                        draw1 += 1
                    if board[a][b] == 'W':
                        draw2 += 1
        answer.append(min(draw1, draw2))

print(min(answer))