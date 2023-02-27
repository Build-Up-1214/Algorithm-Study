import sys
n = int(sys.stdin.readline())
list = []
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    list.append((a,b))
ans = []

# 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1
for i in range(n):
    rank = 1
    for j in range(n):
        if list[i][0] < list[j][0] and list[i][1] < list[j][1]:
            rank += 1
    ans.append(rank)

for a in ans:
    print(a, end=" ")