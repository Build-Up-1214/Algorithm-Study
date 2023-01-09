from collections import deque

N, M = map(int, input().split()) # 큐의 크기, 뽑아 내려고 하는 수의 개수
queue = deque(i for i in range(1, N + 1)) # 1부터 N까지의 수를 queue에 넣는다
pick = list(map(int, input().split())) # 뽑을 수의 위치를 리스트에 넣는다

cnt = 0
for i in pick: # 뽑을 원소를 하나씩 지정
    while True:
        if queue[0] == i: # 뽑을 원소가 queue의 맨 앞에 오면 뽑아내고 break
            queue.popleft()
            break
        else:
            if queue.index(i) <= (len(queue) // 2): # 뽑을 원소가 queue의 중앙에서 왼쪽에 있을 때 왼쪽으로 회전
                queue.rotate(-1)
                cnt += 1
            elif queue.index(i) > (len(queue) // 2): # 뽑을 원소가 queue의 중앙에서 오른쪽에 있을 때 오른쪽으로 회전
                queue.rotate(1)
                cnt += 1

print(cnt)