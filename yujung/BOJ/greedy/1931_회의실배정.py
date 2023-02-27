n = int(input()) # 회의의 수
time = sorted([list(map(int, input().split())) for i in range(n)], key = lambda x:(x[1], x[0]))
answer = end = 0

for s, e in time:
    if s >= end: # 시작 시간이 이전 회의의 종료 시간 이후일 때
        answer += 1 # 경우의 수 + 1
        end = e # 종료 시간을 새로운 회의의 종료 시간으로 갱신
print(answer)