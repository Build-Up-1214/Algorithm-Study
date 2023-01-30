from itertools import combinations

n, m = map(int, input().split()) # 카드의 개수, 제시되는 합
cards = list(map(int, input().split())) # 카드에 쓰인 수
answer = 0

for nCr in combinations(cards, 3):
    if answer < sum(nCr) <= m:
        answer = sum(nCr)

print(answer)