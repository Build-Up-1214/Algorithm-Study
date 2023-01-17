import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())    # N: 총 강의의 수  M: 블루레이의 수
video = list(map(int, input().rstrip().split()))    # video: 각 강의의 길이 (순서대로)

start = max(video)    # 하나의 강의가 나눠져 담기면 안되므로 블루레이 하나의 크기는 강의 길이의 최댓값보다 커야한다.
end = sum(video)    # 블루레이 하나의 크기가 모든 강의 시간을 합한 것보다 클 필요는 없다.
result = end

while start <= end:
    mid = (start + end) // 2    # mid: 블루레이 하나의 크기
    cnt = 1    # 강의를 담기 위해 소요한 블루레이 개수
    sum = 0    # 하나의 블루레이에 들어가는 강의들의 시간 합

    for i in range(len(video)):
        if sum + video[i] <= mid:    # 이전까지 더해온 값과 현재 값을 더한 값이 블루레이 크기보다 작을 경우
            sum += video[i]
        else:    # 더한 값이 블루레이 크기보다 클 경우, 블루레이를 하나 더 소모하고 sum은 현재의 비디오 길이로 초기화한다.
            sum = video[i]
            cnt += 1

    if cnt <= M:        # 개수가 M 보다 작을 경우, 블루레이의 크기를 줄여아하므로 end값을 mid -1 로 수정
        end = mid - 1
        result = min(result, mid)
    else:    # 개수가 M보다 클 경우, 블루레이의 크기를 늘려야하므로 start 값을 mid + 1로 수정
        start = mid + 1

print(result)