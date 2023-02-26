import sys

n = int(sys.stdin.readline())
times = []

for _ in range(n):
    start, end = map(int, sys.stdin.readline().split())
    times.append((start, end))

times = sorted(times, key=lambda x: x[0])  # 시작 시간 기준으로 오름차순
times = sorted(times, key=lambda x: x[1])  # 끝 시간 기준으로 다시 오름차순

last = 0  # 회의의 마지막 시간
cnt = 0  # 회의 갯수
for start, end in times:
    if start >= last:
        cnt += 1
        last = end

print(cnt)