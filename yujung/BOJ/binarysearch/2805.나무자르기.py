n, m = map(int, input().split()) # 나무의 수, 필요한 나무의 길이
tree = list(map(int, input().split())) # 나무의 높이

start, end = 0, max(tree)

while start <= end:
    mid = (start + end) // 2
    _sum = 0
    
    for i in tree:
        if i > mid:
            _sum += i - mid
    
    if _sum >= m:
        start = mid + 1
    else:
        end = mid - 1
        
print(end)