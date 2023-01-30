import sys
input = sys.stdin.readline

n, c = map(int, input().split()) # 집의 개수, 공유기의 개수
house = sorted([int(input()) for _ in range(n)])

start = 1 # 최소 거리
end = house[-1] - house[0] # 최대 거리
answer = 0

while start <= end:
    mid = (start + end) // 2
    now = house[0]
    count = 1
    
    for i in range(1, len(house)):
        if house[i] >= now + mid: # 특정 집 좌표 >= 현재 좌표 + 기준 거리
            count += 1 # 공유기 추가 배치 가능
            now = house[i]
    
    if count >= c: # 설치할 수 있는 공유기 수 >= 설치할 공유기 수
        start = mid + 1 # 더 넓게 설치 가능
        answer = mid
    else:
        end = mid - 1
        
print(answer)