from collections import deque

def solution(priorities, location):
    answer = 1
    
    # 각 요소를 [인덱스, 중요도]의 형태의 리스트로 담는다
    printList = []
    for i in range(len(priorities)):
        printList.append([i, priorities[i]])
    
    # Queue
    printList = deque(printList)
    
    while printList:
        
        # Queue에서 요소 하나를 꺼낸다
        now = printList.popleft()
        
        # 대기열을 순회하며 꺼낸 요소의 중요도가 가장 높은지 확인한다
        max = True
        for i in printList:
            if now[1] < i[1]:
                max = False
        
        # 가장 중요도가 높은 값일 경우
        if max:
            if now[0] == location: # 요청한 문서라면 인쇄 순서를 반환한다
                return answer
            else: # 요청한 문서가 아니라면 인쇄 순서에 1을 더하고 다음 반복으로 넘어간다
                answer += 1
                continue
        
        # 중요도가 가장 높은 값이 아닐 경우 대기 목록에 다시 넣는다
        printList.append(now)
    
    return answer