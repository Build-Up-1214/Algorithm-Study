# 메모리 고려

import sys

N = int(sys.stdin.readline())
n_list = [0] * 10001 # append()를 통해 요소를 추가하는 것은 메모리 재할당으로 인해 효율적이지 않다

for _ in range(N):
    n_list[(int(sys.stdin.readline()))] += 1

for n in range(10001):
    if n_list[n] != 0:
        for m in range(n_list[n]):
            print(n)