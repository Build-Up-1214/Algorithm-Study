import sys

n, k = map(int, sys.stdin.readline().split())

coins = [int(sys.stdin.readline()) for _ in range(n)]
coins.sort(reverse=True) # 동전 종류를 큰 수부터 정렬

cnt = 0
for i in coins:
    if k >= i:
        cnt += k // i
        k %= i

print(cnt)