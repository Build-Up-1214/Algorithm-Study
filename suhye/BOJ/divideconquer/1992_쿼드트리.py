import sys

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]


def quad(x, y, n):
    check = graph[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if check != graph[i][j]: # 하나라도 다르면
                check = -1
                break

    if check == -1:
        print("(", end='')
        n = n // 2
        quad(x, y, n)
        quad(x, y + n, n)
        quad(x + n, y, n)
        quad(x + n, y + n, n)
        print(")", end='')

    elif check == 1:  # 모두 1일때
        print(1, end='')
    else: # 모두 0일때
        print(0, end='')


quad(0, 0, n)