# 문제의 아이디어 : 각 행마다 가장 작은 수를 찾은 뒤, 그 수 중에서 가장 큰 수를 찾는 것
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

card = []
for _ in range(n):
    card.append(list(map(int, input().split())))

pick = 0
for i in card:
    if pick < min(i):
        pick = min(i)

print(pick)


# 책의 풀이 방법

result = 0

for _ in range(n):
    data = list(map(int, input().split()))
    # 현재 행에서 가장 작은 데이터 찾기
    min_card = min(data)

    # 행에서 선택한 가장 작은 카드들 중에서, 가장 큰 수 찾기
    result = max(min_card, result)

print(result)