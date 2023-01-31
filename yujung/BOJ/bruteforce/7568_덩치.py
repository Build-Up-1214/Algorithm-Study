n = int(input()) # 전체 사람 수
h = [list(map(int, input().split())) for _ in range(n)]
for i in h:
    rank = 1
    for j in h:
        if i[0] < j[0] and i[1] < j[1]: # 덩치가 더 큰 사람이 존재하면
            rank += 1 # 랭킹 + 1
    print(rank, end = ' ')