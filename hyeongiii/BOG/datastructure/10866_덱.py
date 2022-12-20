from collections import deque
import sys


n = int(sys.stdin.readline().rstrip())
deque = deque()

for i in range(n):
    command = sys.stdin.readline().rstrip().split()

    if command[0] == 'push_front':
        # deque.appendleft() 시간 복잡도 : O(1)
        deque.appendleft(command[1]) # list.insert(index, 값) : 시간 복잡도 O(n)

    elif command[0] == 'push_back':
        # deque.appendleft() 시간 복잡도 : O(1)
        deque.append(command[1])

    elif command[0] == 'pop_front':
        if not deque:
            print(-1)
        else:
            # deque.popleft() 시간 복잡도 : O(1)
            print(deque.popleft())
        # print(deque.popleft() if deque else -1)

    elif command[0] == 'pop_back':
        if not deque:
            print(-1)
        else:
            # deque.pop() 시간 복잡도 : O(1)
            print(deque.pop())

    elif command[0] == 'size':
        print(len(deque))

    elif command[0] == 'empty':
        if not deque:
            print(1)
        else:
            print(0)

    elif command[0] == 'front':
        if not deque:
            print(-1)
        else:
            print(deque[0])

    elif command[0] == 'back':
        if not deque:
            print(-1)
        else:
            print(deque[-1])