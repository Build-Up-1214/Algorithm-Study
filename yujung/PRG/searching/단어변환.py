from collections import deque

# BFS: 최단 거리
def solution(begin, target, words):
    
    if target not in words:
        return 0
    
    queue = deque()
    queue.append([begin, 0])
    
    while queue:
        now, cnt = queue.popleft()
        
        if now == target: # 현재 단어가 타겟 단어와 같다면 변환 과정 수 반환
            return cnt
        
        for i in range(len(words)):
            diff = 0
            word = words[i] # 배열 words의 단어 하나하나에 접근
            for j in range(len(word)): # 접근한 단어의 알파벳 하나하나에 접근
                if now[j] != word[j]: # 현재 단어와 비교하는 단어가 알파벳 하나 차이인지 검사
                    diff += 1
            if diff == 1:
                queue.append([word, cnt + 1]) # 알파벳 하나 차이일 경우 현재 비교하는 단어를 Queue에 넣는다
    
    return cnt