N, M = map(int, input().split())

answer = []

def dfs():
    if len(answer) == M:
        print(' '.join(map(str, answer)))
        return
    
    for i in range(1, N + 1):
        answer.append(i)
        dfs()
        answer.pop()
        
dfs()