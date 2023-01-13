n = int(input()) # 계단의 개수
_list = [int(input()) for _ in range(n)] # 계단 점수
dp = [0] * n

if len(_list) <= 2: # 계단이 2개 이하일 땐 모두 더한다
    print(sum(_list))
else:
    dp[0] = _list[0] # 첫 번째 계단
    dp[1] = _list[0] + _list[1] # 두 번째 계단
    for i in range(2, n): # 세 번째 계단 ~
        dp[i] = max(dp[i - 3] + _list[i - 1] + _list[i], dp[i - 2] + _list[i])
    print(dp[-1])