import sys
input = sys.stdin.readline

N, C = map(int, input().split())
house = []
for _ in range(N):
    house.append(int(input()))

house.sort()

start = 1    # 공유기 간격의 최소값
end = house[-1] - house[0]    # 공유기 간격의 최대값

result = 0


while start <= end:
    mid = (start + end) // 2    # 공유기 간격(공유기 사이의 거리)
    cnt = 1    # 사용된 공유기 개수
    idx = house[0]    # idx: 공유기가 설치된 마지막 집의 위치

    for i in range(1, N):
        if house[i] >= mid + idx:    # i번째 집의 x좌표 - 직전에 공유기가 설치된 집의 x좌표 = 공유기 간격
            cnt += 1
            idx = house[i]    # 공유기 설치

    if cnt >= C:
        start = mid + 1
    else:
        end = mid - 1

print(end)
