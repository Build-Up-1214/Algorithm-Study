from collections import deque

N = int(input())
queue = deque()

for i in range(1, N + 1):
    queue.append(i)

while len(queue) != 1: # Queue에 데이터 1개가 남을 때까지 반복한다
    queue.popleft() # 가장 위에 있는 카드를 버린다
    top = queue.popleft() # 그 다음으로 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다
    queue.append(top)
    
print(queue[0]) # 마지막에 남은 카드를 출력한다