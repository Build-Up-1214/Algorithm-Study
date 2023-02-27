import sys

n = int(sys.stdin.readline())

p = list(map(int, sys.stdin.readline().split()))

p.sort(reverse=True)

sum = 0
for i in range(n):
    sum += p[i]*(i+1)

print(sum)