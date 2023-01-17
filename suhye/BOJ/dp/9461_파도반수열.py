T = int(input())
p = [1, 1, 1, 2, 2]

for i in range(4, 100):
    p.append(p[i] + p[i - 4])

for _ in range(T):
    n = int(input())
    print(p[n - 1])