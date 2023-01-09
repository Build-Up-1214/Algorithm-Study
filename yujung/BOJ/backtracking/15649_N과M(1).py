N, M = map(int, input().split())

answer = []

def dfs():
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return
    
    for i in range(1, N + 1):
        if i not in answer:
            answer.append(i) # 리스트에 존재하지 않을 경우 넣기
            dfs() # 재귀 함수
            answer.pop() # 숫자 하나 꺼내기

dfs()