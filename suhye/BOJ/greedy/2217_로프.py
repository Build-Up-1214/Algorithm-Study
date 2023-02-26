import sys

n = int(sys.stdin.readline())

ropes = [int(sys.stdin.readline()) for _ in range(n)]

ropes.sort(reverse=True)
res = []

for i in range(n):
    res.append(ropes[i]*(i+1))

print(max(res))
