N = int(input())
n_list = []

for _ in range(N):
    n_list.append(int(input()))

n_list.sort()

for n in n_list:
    print(n, end = '\n')