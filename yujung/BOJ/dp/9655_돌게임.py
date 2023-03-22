n = int(input())
dp = [-1] * 1001
dp[1] = 1 # 돌이 1개일 때 SK 승
dp[2] = 0 # CY
dp[3] = 1

for i in range(4, n + 1):
    if dp[i - 1] == 1 or dp[i - 3] == 1: # i에서 1이나 3을 뺐을 때 상근이가 이기는 경우라면 i는 창영이가 이기는 경우이다
        dp[i] = 0
    else:
        dp[i] = 1

if dp[n] == 1:
    print("SK")
else:
    print("CY")