# import itertools
import sys

heights = [int(sys.stdin.readline()) for _ in range(9)]

heights.sort()
gap = sum(heights) - 100
lt, rt = 0, 8
while lt <= rt:
    temp = heights[lt] + heights[rt]
    if temp == gap:
        heights.remove(heights[lt])
        heights.remove(heights[rt-1]) # heights[lt]가 삭제되었기 때문에 -1
        break
    elif temp > gap:
        rt -= 1
    else:
        lt += 1
for i in heights:
    print(i)

# # combinations 사용한 풀이
# for i in itertools.combinations(heights, 7):
#     if sum(i) == 100:
#         for j in sorted(i):  # 7명을 정렬 후 출력
#             print(j)
#         break
