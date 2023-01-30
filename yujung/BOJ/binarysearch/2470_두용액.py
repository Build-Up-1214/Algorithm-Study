n = int(input()) # 전체 용액의 수
arr = sorted(list(map(int, input().split()))) # 각 용액의 특성값
min_s = 2000000001 # 두 용액의 합 (0과 가까워야 한다)

if n == 2:
    print(arr[0], arr[1])
    exit(0)

for i in range(n - 1):
    start = i + 1 # 현재 값의 오른쪽 값부터 탐색
    end = n - 1 # 인덱스 주의
    
    while start <= end:
        mid = (start + end) // 2
        s = arr[i] + arr[mid] # 두 용액의 합
        
        if abs(s) < min_s: # 두 용액의 합이 0과 더 가까운 값이라면 갱신
            v1, v2 = i, mid
            min_s = abs(s)
        
        if s < 0: # 두 용액의 합이 0보다 작다면
            start = mid + 1 # 오른쪽 구역 탐색
        else:
            end = mid - 1

print(arr[v1], arr[v2])