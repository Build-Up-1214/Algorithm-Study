n, m = map(int, input().split()) # 강의의 수, 블루레이의 수
minute = list(map(int, input().split()))

start, end = max(minute), sum(minute)
target = sum(minute)

res = 10 ** 9
while start <= end:
    mid = (start + end) // 2
    
    cnt = 1 # 필요한 블루레이의 수
    now = 0
    for i in minute:
        if now + i <= mid: # 현재 블루레이에 강의를 추가로 넣을 수 있는 경우
            now += i
        else:
            cnt += 1
            now = i # 추가로 넣을 수 없다면 해당 길이를 기준으로 남은 반복 돌려 보기
            if cnt > m: # 필요한 블루레이의 수가 정해진 수를 초과한 경우
                break
        
    if cnt > m:
        start = mid + 1 # 각 블루레이의 한정 시간을 늘려야 한다
    else:
        end = mid - 1
        # 블루레이 크기의 최소값을 찾는 문제이다
        res = min(res, mid)

print(res)