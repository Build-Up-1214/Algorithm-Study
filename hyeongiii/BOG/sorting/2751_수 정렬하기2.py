import sys

num = int(sys.stdin.readline().rstrip())
li = []

for _ in range(num):
    li.append(int(sys.stdin.readline().rstrip()))

li.sort()

for i in li:
    print(i)