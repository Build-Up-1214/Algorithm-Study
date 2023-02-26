""" 내가 푼 풀이 """
import sys
import itertools
input = sys.stdin.readline

n = int(input())
coin = list(map(int, input().split()))
worth = []
coin.sort()

for i in range(1, len(coin) + 1):
    for j in itertools.combinations(coin, i):
        worth.append(sum(list(j)))

for i in range(1, sum(coin) + 2):
    if i not in worth:
        print(i)
        break


""" 책 풀이 """
n = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for x in data:
    # 만들 수 없는 금액을 찾았을 때, 반복 종료
    if target < x:
        break
    target += x

# 만들 수 없는 금액 출력
print(target)