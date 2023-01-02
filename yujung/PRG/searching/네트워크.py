from collections import deque

def solution(n, computers):
    
    # 모든 경로 방문: DFS
    
    visited = [False] * n # 각 컴퓨터 방문 여부
    count = 0 # 여러 컴퓨터가 연결된 한 네트워크의 묶음 수
    
    def dfs(i):
        visited[i] = True # 컴퓨터 i 방문 처리
        
        for j in range(n): # 컴퓨터 i와 인접한 컴퓨터 탐색
            if not visited[j] and computers[i][j]: # 방문하지 않았고, 연결되지 않은 컴퓨터가 있으면
                dfs(j) # 해당 컴퓨터를 또 dfs 탐색 (여기에서는 새롭게 탐색하는 네트워크가 아니므로 count 증가하지 않음)
    
    for i in range(n): # 컴퓨터 개수만큼 반복
        if not visited[i]: # 방문하지 않은 컴퓨터인 경우 dfs로 탐색
            dfs(i)
            count += 1 # 새롭게 탐색하는 네트워크이므로 증가
    
    return count