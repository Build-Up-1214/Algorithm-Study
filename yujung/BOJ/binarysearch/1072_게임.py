x, y = map(int, input().split()) # 게임 횟수, 이긴 게임
z = int(y * 100 // x) # y / x * 100의 경우 오차 발생

if z >= 99:
    print(-1) # 승률이 99퍼인 경우 이미 진 게임이 있다는 의미이므로 승률이 100이 될 수 없다
else:
    start, end = 1, 1000000000
    
    while start <= end:
        mid = (start + end) // 2 # 진행할 게임 횟수
        if int((y + mid) / (x + mid) * 100) > z: # mid만큼 게임을 진행했을 때 승률이 오른 경우
            end = mid - 1 # end를 줄여서 탐색해 보기
        else:
            start = mid + 1 # 승률이 오르지 않을 경우 start를 높여서 탐색해 보기
    print(end + 1) # 승률이 오르는 최소 값이 if문에서 True가 되므로 end 값이 -1 줄어든다