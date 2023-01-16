n = int(input()) # 수열의 크기
_list = list(map(int, input().split()))
dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if _list[j] < _list[i]: # 기준 숫자가 이전 숫자보다 크면
            dp[i] = max(dp[i], dp[j] + 1) # 자신의 길이(최신화 진행 중)와 이전 숫자 + 1의 크기를 비교하여 최신화
            
print(max(dp))