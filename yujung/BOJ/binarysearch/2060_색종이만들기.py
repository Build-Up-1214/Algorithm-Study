n = int(input()) # 전체 종이의 한 변의 길이
paper = [list(map(int, input().split())) for _ in range(n)]

answer = []
def cut(x, y, n):
    color = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if color != paper[i][j]:
                # 구역을 사분면으로 나눠서 탐색
                cut(x, y, n // 2)
                cut(x, y + n // 2, n // 2)
                cut(x + n // 2, y, n // 2)
                cut(x + n // 2, y + n // 2, n // 2)
                return
    if color == 0: # white
        answer.append(0)
    else: # blue
        answer.append(1)

cut(0, 0, n)
print(answer.count(0))
print(answer.count(1))