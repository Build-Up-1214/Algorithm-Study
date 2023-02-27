n = int(input()) # 도시의 개수
roads = list(map(int, input().split())) # 도시를 연결하는 도로의 길이
costs = list(map(int, input().split())) # 주유소의 리터당 가격

answer = roads[0] * costs[0]
min_cost = costs[0] # 가격이 제일 작은 값을 갱신해 가며 계산
for i in range(1, n - 1):
    if min_cost > costs[i]: # 더 가격이 낮은 주유소를 발견하면
        min_cost = costs[i] # min_cost를 갱신하고, 해당 값을 기준으로 계산해 나감
    answer += min_cost * roads[i]

print(answer)