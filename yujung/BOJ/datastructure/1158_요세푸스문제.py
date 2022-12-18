from collections import deque

n, k = map(int, input().split())
result = []

queue = deque()
for i in range(1, n + 1):
    queue.append(i) # 1부터 n까지의 숫자를 Queue에 담는다

while queue: # Queue에 데이터가 남아 있다면 반복한다
    for i in range(k - 1): # Queue에서 k - 1번째의 순서까지 빼낸 후 다시 넣는다
        restart = queue.popleft()
        queue.append(restart)
    
    result.append(queue.popleft()) # Queue에서 k번째 순서를 빼내서 리스트 result에 담는다
    
print("<%s>" % ", ".join(map(str, result))) # 리스트 result에 담긴 숫자를 형식에 맞게 출력한다