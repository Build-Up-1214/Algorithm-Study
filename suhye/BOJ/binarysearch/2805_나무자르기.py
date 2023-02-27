import sys
# 나무의 수 n, 가져가야하는 길이 m, 나무의 높이 리스트 height
n, m = map(int, sys.stdin.readline().split())
height = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(height)
while start <= end:
    mid = (start + end) // 2
    total = 0  # 가져갈 수 있는 나무 길이 합
    for h in height:
        if h > mid:
            total += h - mid
    if total >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)
