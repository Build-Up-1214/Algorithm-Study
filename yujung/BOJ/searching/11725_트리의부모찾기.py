import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input()) # 노드의 개수

tree = [[] for _ in range(n + 1)]
parents = [0 for _ in range(n + 1)] # 최종 출력할 배열

for _ in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(n, tree, parents):
    for i in tree[n]: # n번 노드와 연결된 노드
        if parents[i] == 0: # n번의 부모 노드에 값이 없다면
            parents[i] = n # 해당 부모 노드에 n를 넣는다
            dfs(i, tree, parents) # 다음 연결 노드도 반복

dfs(1, tree, parents)

for i in range(2, n + 1):
    print(parents[i])