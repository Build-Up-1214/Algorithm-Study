n_list = [0] * 5
sum = 0
for i in range(5):
    n_list[i] = int(input())
    sum += n_list[i]

n_list.sort()

print(sum // 5, n_list[2], sep = "\n")