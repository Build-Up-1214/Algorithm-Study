n = int(input()) # 지방의 수
cities = list(map(int, input().split()))
m = int(input()) # 총 예산

start = 0
end = max(cities)

while start <= end:
    mid = (start + end) // 2 # 상한액
    total = 0
    
    for i in cities:
        if i > mid: # 요청 금액이 상한액 이상이면 상한액을 더한다
            total += mid
        else: # 요청 금액이 상한액 이하이면 요청 금액을 더한다
            total += i
            
    if total <= m: # 예산 총액이 총 예산 이하일 경우
        start = mid + 1 # 상한액 증가 초기화
    else: # 예산 총액이 총 예산 이상일 경우
        end = mid - 1 # 상한액 감소 초기화

print(end) # 상한액 최대값
    