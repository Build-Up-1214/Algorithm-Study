# 조카 수 m, 막대과자 수 n
m, n = map(int, input().split())
snacks = list(map(int, input().split()))

result = 0
start = 0
end = max(snacks)

while (start <= end):
    total = 0 # 줄 수 있는 사람 수
    mid = (start + end) // 2

    if mid == 0:
        break

    for snack in snacks:
        if snack >= mid:
            total += snack // mid
    if total >= m:
        start = mid + 1
        result = mid
    else:
        end = mid - 1
print(result)