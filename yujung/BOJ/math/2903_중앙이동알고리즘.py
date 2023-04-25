n = int(input())
n_list = [0 for _ in range(16)]
a = 2
b = 1

for i in range(1, n + 1):
    a += b
    n_list[i] = a * a
    b *= 2

print(n_list[n])