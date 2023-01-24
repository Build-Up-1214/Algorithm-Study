import sys

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = [0, 0, 0]

def paper(x, y, z):
    global answer
    check = graph[x][y]
    for i in range(x, x + z):
        for j in range(y, y + z):
            if check != graph[i][j]:
                for k in range(3):
                    for l in range(3):
                        paper(x + k * z // 3, y + l * z // 3, z // 3)
                return
    # 카운트
    if check == -1:
        answer[0] += 1
    elif check == 0:
        answer[1] += 1
    else:
        answer[2] += 1


paper(0, 0, n)
[print(i) for i in answer]