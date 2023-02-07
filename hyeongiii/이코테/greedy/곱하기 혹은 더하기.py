import sys
input = sys.stdin.readline

data = list(input().rstrip())
result = 0
for i in data:
    if int(i) == 0 or result == 0:
        result += int(i)
    else:
        result *= int(i)

print(result)