import sys
input = sys.stdin.readline

# 지방의 수 입력 받기
N = int(input())
# 지방의 예산 요청 금액 입력 받기
money = list(map(int, input().rstrip().split()))
# 국가 예산 총액 입력 받기
M = int(input())

# 만약 지방의 예산 요청 금액의 총합이 국가 예산 총액보다 적을 경우
if sum(money) <= M:
    print(max(money))

else:
    start = 1
    end = max(money)

    while start <= end:
        mid = (start + end) // 2
        # 상한액이 mid일 때, 지방 예산의 총합
        sum = 0
        for i in money:
            if i <= mid:    # 지방 예산 요청 금액이 상한액 보다 적을 때
                sum += i
            else:    # 지방 예산 요청 금액이 상한액 보다 클 때
                sum += mid

        # 이분 탐색 적용
        if sum <= M:
            start = mid + 1
        else:
            end = mid - 1

    print(end)