import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
data = list(map(int, input().rstrip().split()))

data.sort(reverse=True)

a = m // (k + 1)
b = m % (k + 1)

answer = 0
answer += data[0] * a * k + data[1] * a
answer += data[0] * b

print(answer)