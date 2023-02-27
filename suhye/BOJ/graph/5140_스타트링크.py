import sys
from collections import deque
# F, S, G, U, D
# 총 F층, 강호가 지금 있는 곳은 S층, 스타트링크가 있는 곳의 위치 G층, U: 위로 U층을 가는 버튼, D: 아래로 D층을 가는 버튼
# S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력
f, s, g, u, d = map(int, sys.stdin.readline().split())

cnt = [0]*(f+1)
visit = [0]*(f+1)
def bfs(v):
    q = deque()
    q.append(v)
    visit[v] = 1
    while q:
        v = q.popleft()
        if v == g:
            return cnt[v]
        for i in (v + u, v - d):
            if 1 <= i <= f and visit[i] == 0:
                q.append(i)
                cnt[i] = cnt[v] + 1
                visit[i] = 1
    if cnt[g] == 0:
        return "use the stairs"

print(bfs(s))

# 1697 문제와 유사

