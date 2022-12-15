from collections import deque
import math

def solution(progresses, speeds):
    
    day = deque() # 각 진도가 100% 완료되는 날짜를 게산하여 넣는다
    answer = [] # 반환값
    
    for i in range(len(progresses)):
        day.append(math.ceil((100 - progresses[i]) / speeds[i])) # 나눴을 때 소수일 경우 반올림 한다
    
    while day: # 모든 작업이 배포될 때까지 반복한다
        
        current = day.popleft()
        count = 1 # 하나의 배포 단위에 배포되는 기능의 수
        
        # 작업 대기열이 남아 있고, 맨 앞의 작업보다 뒤의 작업의 완료 날짜가 적다면 함께 배포되므로 count를 1 증가시킨다
        while len(day) != 0 and day[0] <= current:
            count += 1
            day.popleft() # 뒤의 작업은 앞의 작업과 함께 배포되므로 대기열에서 삭제한다
        
        answer.append(count)
    
    return answer