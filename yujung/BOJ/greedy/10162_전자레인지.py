t = int(input())
ABC = [300, 60, 10]
abc = [0, 0, 0]

for i in range(len(ABC)):
    abc[i] = t // ABC[i]
    t %= ABC[i]

if t == 0:
    print(*abc)
else:
    print(-1)