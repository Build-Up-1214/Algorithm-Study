s = int(input())
_sum = 0

for i in range(1, s + 1): # 1부터 s까지의 수를 더해 가며 s를 넘어가는 시점을 찾는다
    _sum += i
    if _sum > s:
        print(i - 1)
        exit(0)
    elif _sum == s:
        print(i)
        exit(0)