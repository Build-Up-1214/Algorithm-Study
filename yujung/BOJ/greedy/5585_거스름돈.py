m = 1000 - int(input())
n = [500, 100, 50, 10, 5, 1]
answer = 0

for i in n:
    answer += m // i
    m %= i
print(answer)