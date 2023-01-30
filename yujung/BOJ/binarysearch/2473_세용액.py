n = int(input()) # 용액의 수
arr = sorted(list(map(int, input().split()))) # 각 용액의 특성값
min_s = 3000000001 # 0과 가장 가까운 값
x, y, z = 0, 0, 0

for i in range(n - 2):
    start = i + 1
    end = n - 1
    
    while start < end: # start = end이면 같은 용액이 된다
        s = arr[i] + arr[start] + arr[end]
        
        if abs(s) < min_s:
            min_s = abs(s)
            x, y, z = arr[i], arr[start], arr[end]
            
        if s < 0: # 0과 가까워지려면 좀 더 큰 값을 더해야 하므로 start + 1
            start += 1
        elif s > 0: # 0과 가까워지려면 좀 더 작은 값을 더해야 하므로 end - 1
            end -= 1
        else: # s == 0이라면 반복 종료
            break
print(x, y, z)