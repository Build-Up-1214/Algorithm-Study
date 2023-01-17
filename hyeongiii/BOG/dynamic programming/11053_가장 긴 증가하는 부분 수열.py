import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().rstrip().split()))

# dp : data[i]를 마지막 원소로 가질 때, 증가하는 부분 수열의 길이
dp = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if data[i] > data[j]:
            dp[i] = max(dp[j] + 1, dp[i])

print(max(dp))

'''
data = 10 20 10 30 20 50
예를 들어, i = 4 일때

i = 4, j = 0, dp[4] = 1
data[4] > data[0] : true
dp[4] = max(dp[4], dp[0] + 1)  -> 2

i = 4, j = 1, dp[4] = 2
data[4] > data[1] : false

i = 4, j = 2, dp[4] = 2
data[4] > data[2] : true
dp[4] = max(dp[4], dp[2] + 1) -> 2

i = 4, j = 3, dp[4] = 2
data[4] > data[3] : false

n 개의 수에 대해 현재 위치 이전의 모든 수를 다 훑어봐야하므로 시간복잡도 : O(N^2)
'''