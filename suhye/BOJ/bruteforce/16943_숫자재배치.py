import itertools
import sys

a, b = sys.stdin.readline().split()
b = int(b)
c_list = list(map(''.join, list(itertools.permutations(a))))

c = -1
for i in c_list:
    if i[0] == '0': # 0으로 시작하는 경우
        continue
    i = int(i)
    if i < b:
        c = max(c, i)

print(c)
