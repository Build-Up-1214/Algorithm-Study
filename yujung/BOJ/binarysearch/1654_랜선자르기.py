k, n = map(int, input().split()) # 가지고 있는 랜선의 개수, 필요한 랜선의 개수
k_list = list(int(input()) for _ in range(k))

k_list.sort()
start, end = 1, k_list[k - 1]

while start <= end:
    mid = (start + end) // 2
    
    _sum = 0
    for i in k_list: # 만들 수 있는 랜선 수
        _sum += i // mid
    
    if _sum >= n: # 만들 수 있는 랜선 수가 필요한 수보다 클 때
        start = mid + 1
    else: # 만들 수 있는 랜선 수가 필요한 수보다 적을 때
        end = mid - 1

print(end)