import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
num = list(map(int, input().rstrip().split()))

answer = 0

num.sort()

while True:
    for _ in range(k):    # 최대로 반복할 수 있는 횟수만큼 반복
        if m == 0:
            break
        answer += num[-1]
        m -= 1

    if m == 0:    # 최대 반복 횟수를 채우면 두 번째로 큰 값을 더해줘야 한다.
        break
    answer += num[-2]
    m -=1

print(answer)