# 랜선의 개수 k, 필요한 랜선 개수 n, 랜선 리스트 lan
import sys

k, n = map(int, sys.stdin.readline().split())
lan = [int(sys.stdin.readline()) for _ in range(k)]

start = 1
end = max(lan)

while start <= end:
    mid = (start + end) // 2
    total = 0
    for i in lan:
        total += i // mid
    if total >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)