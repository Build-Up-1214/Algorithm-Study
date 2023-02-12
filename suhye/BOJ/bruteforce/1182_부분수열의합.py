import sys
from itertools import combinations

n, s = map(int, sys.stdin.readline().split())

list = list(map(int, sys.stdin.readline().split()))

cnt = 0

# combinations 함수 사용
# for i in range(1, n+1):
#     for j in combinations(list, i):
#         if sum(j) == s:
#             cnt += 1

# 재귀함수와 백트래킹을 활용한 풀이법
def subset_sum(idx, sub_sum):
    global cnt

    if idx >= n:
        return

    sub_sum += list[idx]

    if sub_sum == s:
        cnt += 1

    subset_sum(idx+1, sub_sum) # 현재 list[idx]를 선택한 경우의 가지
    subset_sum(idx+1, sub_sum - list[idx]) # 현재 list[idx]를 선택하지 않은 경우의 가지

subset_sum(0, 0)
print(cnt)