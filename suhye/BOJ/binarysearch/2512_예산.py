import sys

n = int(sys.stdin.readline())
budget = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())

budget.sort()
start = 0
end = max(budget)

while start <= end:
    mid = (start + end) // 2
    total = 0
    for i in budget:
        if i >= mid:
            total += mid
        else:
            total += i
    if total > m:
        end = mid - 1
    else:
        start = mid + 1

print(end)