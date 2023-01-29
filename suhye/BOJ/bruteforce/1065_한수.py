import sys

n = int(sys.stdin.readline())
# 1,000보다 작거나 같은 자연수 n
# 1~99, 100~999 범위로 나눠서 탐색
cnt = 0
for i in range(1, n+1):
    if i <= 99:
        cnt += 1
    else:
        n_list = list(map(int, str(i)))
        if n_list[2] - n_list[1] == n_list[1] - n_list[0]:
            cnt += 1

print(cnt)