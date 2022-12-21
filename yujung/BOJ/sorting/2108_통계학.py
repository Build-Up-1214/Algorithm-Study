import sys
from collections import Counter

N = int(sys.stdin.readline())
n_list = [0] * N
for i in range(N):
    n_list[i] = int(sys.stdin.readline())

# 산술 평균
print(round(sum(n_list) / N))

# 중앙값
n_list.sort()
print(n_list[N // 2])

# 최빈값 (여러 개 있을 때는 두 번째로 작은 값)
cnt = Counter(n_list)
num = cnt.most_common()
max_num = num[0][1]
num_list = []

for i in range(1, len(num)):
    if num[i][1] == max_num: # 최빈값이 동일한 값이 있을 때
        num_list.append(num[i][0])

if len(num_list) == 0: # 원소가 하나일 때
    print(num[0][0])
else:
    print(num_list[0])

# 범위
print(n_list[len(n_list) - 1] - n_list[0])