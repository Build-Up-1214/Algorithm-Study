import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
height = list(map(int, input().rstrip().split()))

# 절단기 설정 높이의 최솟값
lt = 0
# 절단기 설정 높이의 최댓값
hi = max(height)

while lt <= hi:
    mid = (lt + hi) // 2
    # 각 나무에 대해 mid 값이 절단기 설정 높이일 때, 가져갈 수 있는 나무 길이의 합
    sum = 0
    for i in height:
        # 각 나무의 길이가 절단기 높이 설정보다 높으면,
        if i > mid:
            # 나무를 베어낸 길이를 더한다.
            sum += (i - mid)

    # 벌목 높이를 이분 탐색
    if sum >= m:    # 만약 mid가 절단기 설정 높이일 때, m 이상의 길이를 가져갈 수 있을 경우 -> 최댓값을 구해야하므로 최소범위를 mid로 늘린다.
        lt = mid + 1
    else:    # 만약 mid가 절단기 설정 높이일 때, m 이상의 길이를 가져갈 수 없을 경우 -> 절단기 설정 최대 범위를 mid로 줄인다.
        hi = mid - 1

print(hi)
