N = int(input())

arr = [5001] * (N + 5)
arr[3] = arr[5] = 1 # 3kg과 5kg은 한 봉지 사용

for i in range(6, N + 1):
    arr[i] = min(arr[i - 3], arr[i - 5]) + 1 # 해당 위치보다 3 혹은 5 작은 위치 중 작은 값을 가져와서 1을 더한다
    
print(arr[N] if arr[N] < 5001 else -1) # N kg을 만들 수 없으면 -1을 반환한다