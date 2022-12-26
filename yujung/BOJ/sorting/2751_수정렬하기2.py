# 시간 고려

import sys

N = int(sys.stdin.readline())
n_list = []

for _ in range(N):
    n_list.append(int(sys.stdin.readline()))

n_list.sort()

for n in n_list:
    print(n, end = '\n')