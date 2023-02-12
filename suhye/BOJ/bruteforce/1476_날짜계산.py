import sys

# 지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M
# (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

e, s, m = map(int, sys.stdin.readline().split())

year = 1
while True:
    if (year - e) % 15 == 0 and (year - s) % 28 == 0 and (year - m) % 19 == 0:
        print(year)
        break
    else:
        year += 1