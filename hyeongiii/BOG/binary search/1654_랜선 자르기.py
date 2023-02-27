import sys
input = sys.stdin.readline

K, N = map(int, input().split())    # K: 이미 가지고 있는 랜선의 수  N: 필요한 랜선의 수
# K개의 랜선의 각 길이 입력 받기
data = []
for _ in range(K):
    data.append(int(input()))

# 만들 수 있는 랜선의 길이
start, end = 1, max(data)

while start <= end:
    mid = (start + end) // 2    # mid: 만들 수 있는 랜선의 길이
    cnt = 0    # 잘라서 만든 랜선의 개수
    for i in data:
        cnt += (i // mid)    # 분할된 랜선의 개수

    if cnt >= N:    # 랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1

print(end)




