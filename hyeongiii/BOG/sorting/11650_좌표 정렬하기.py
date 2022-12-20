import sys
input = sys.stdin.readline

num = int(input().rstrip())
li = []

for _ in range(num):
    li.append(list(map(int, input().rstrip().split())))

li.sort(key=lambda x: (x[0], x[1]))

for i in li:
    print(i[0], i[1])