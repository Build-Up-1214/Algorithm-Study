m = int(input())
n = int(input())

sieve = [True] * (n + 1)
sieve[0], sieve[1] = False, False

for i in range(2, int(n ** 0.5) + 1):
    if sieve[i]:
        for j in range(i + i, n + 1, i):
            sieve[j] = False

min_num = []
for i in range(m, n + 1):
    if sieve[i]:
        min_num.append(i)
if len(min_num) != 0:
    print(sum(min_num))
    print(min(min_num))
else:
    print(-1)