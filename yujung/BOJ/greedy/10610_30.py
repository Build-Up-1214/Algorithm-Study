n = list(input())
n.sort(reverse = True)

answer = 0
# 배수판정법
for i in n:
    answer += int(i)

if answer % 3 != 0 or "0" not in n:
    print(-1)
else:
    print(''.join(n))