import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

a.sort()
s = 0
for i in range(n):
    s += a[i] * b.pop(b.index(max(b)))  # b는 재배열하지 않는 조건에 따라

# b.sort(reverse=True)
# for i in range(n):
#     s += a[i]*b[i]

print(s)
