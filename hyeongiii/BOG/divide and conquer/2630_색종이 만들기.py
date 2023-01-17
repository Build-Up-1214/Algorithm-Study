import sys

input = sys.stdin.readline

# 정수 입력 받기
num = int(input())
# 색종이 입력 받기
paper = [list(map(int, input().rstrip().split())) for _ in range(num)]

result = [0, 0]


def solution(x, y, num):
    color = paper[x][y]  # 첫 번째 색
    for i in range(x, x + num):
        for j in range(y, y + num):
            if color != paper[i][j]:
                solution(x, y, num // 2)
                solution(x, y + num // 2, num // 2)
                solution(x + num // 2, y, num // 2)
                solution(x + num // 2, y + num // 2, num // 2)
                return 0
    # 모든 범위 내의 종이 색깔이 같을 경우
    if color == 0:
        result[0] += 1
    else:
        result[1] += 1


solution(0, 0, num)
for a in result:
    print(a)
