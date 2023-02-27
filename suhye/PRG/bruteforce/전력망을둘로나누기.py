def dfs(v, graph, visit, cut):
    cnt = 1
    visit[v] = True
    for i in graph[v]:
        if visit[i] == False and cut[v][i] == False:
            cnt += dfs(i, graph, visit, cut)
    return cnt

def solution(n, wires):
    answer = n

    # 그래프 생성
    graph = [[] for _ in range(n+1)]
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)

    cut = [[False]*(n+1) for _ in range(n+1)]
    for v1, v2 in wires:
        # wires의 행을 순회하면서 하나씩 끊어본다.
        # 끊은 상태로 각각 연결된 것의 개수를 카운트한다.
        visit = [False]*(n+1)
        cut[v1][v2] = True
        cnt1 = dfs(v1, graph, visit, cut)
        cnt2 = dfs(v2, graph, visit, cut)
        cut[v1][v2] = False
        # 그 중 최솟값을 리턴한다.
        answer = min(answer, abs(cnt1 - cnt2))
    return answer