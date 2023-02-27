import sys
from collections import deque
n, k = map(int, sys.stdin.readline().split())
visited = [0]*100001

def bfs():
    q = deque()
    q.append(n)
    while q:
        v = q.popleft()
        if v == k:
            return visited[v]
        for i in (v-1, v+1, v*2):
            if 0 <= i <= 100000 and visited[i] == 0: # and 앞뒤 순서가 바뀌면 IndexError 발생. 먼저 i의 범위를 제한한 뒤 not visited[i] 여부를 확인해야 한다.
                visited[i] = visited[v] + 1
                q.append(i)

print(bfs())

