from collections import deque
import sys

input = sys.stdin.readline

n, m, v = map(int, input().split())

# 행렬 만들기
graph = [[False] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = True

# 방문 리스트 행렬
dfs_visited = [False] * (n + 1)  # DFS 방문 기록
bfs_visited = [False] * (n + 1)  # BFS 방문 기록


# DFS
def dfs(v):
    dfs_visited[v] = True  # 해당 v값(정점) 방문 처리
    print(v, end=" ")

    for i in range(1, n + 1):
        if not dfs_visited[i] and graph[v][i]:  # 만약 정점 i를 방문하지 않았고, i가 v와 연결되어 있다면
            dfs(i)  # 해당 i값으로 dfs 탐색 (더 깊이 탐색)


# BFS
def bfs(v):
    q = deque()  # pop 메서드의 시간복잡도가 가장 낮은 deque의 내장 메서드 이용
    q.append(v)
    bfs_visited[v] = True

    while q:  # q가 빌 때까지 반복
        v = q.popleft()  # 큐에 있는 첫 번째 값을 꺼냄
        print(v, end=" ")
        for i in range(1, n + 1):
            if not bfs_visited[i] and graph[v][i]:
                q.append(i)
                bfs_visited[i] = True


dfs(v)
print()
bfs(v)
