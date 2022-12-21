import sys

input = sys.stdin.readline

num = int(input())
li = []

for i in range(num):
    li.append(int(input().rstrip()))

li.sort()

for x in li:
    print(x)