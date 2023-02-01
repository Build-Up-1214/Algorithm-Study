# 내가 푼 풀이
p = input()

r = p[1]
c = p[0]

column = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
r_start = int(r)
c_start = column.index(c)
cnt = 0

dr = [-2, -2, 2, 2, -1, -1, 1, 1]
dc = [-1, 1, -1, 1, -2, 2, -2, 2]

for i in range(len(dr)):
    nr = r_start + dr[i]
    nc = c_start + dc[i]

    if nr > 8 or nr < 1 or nc > 7 or nc < 0:
        continue
    else:
        cnt += 1

print(cnt)


# 예시 답안
# 현재 나이트의 위치 입력 받기
data = input()
row = int(data[1])
col = int(ord(data[0])) - int(ord('a')) + 1

# 나이트가 이동할 수 있는 8가지 방향 정의
steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]

# 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
result = 0

for step in steps:
    # 이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_col = col + step[1]
    # 해당 위치로 이동이 가능하다면 카운트 증가
    if 8 >= next_row >= 1 and 8 >= next_col >= 1:
        result += 1

print(result)