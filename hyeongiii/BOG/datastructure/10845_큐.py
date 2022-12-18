import sys

n = int(sys.stdin.readline().rstrip())

queue = []
for i in range(n):
    command = sys.stdin.readline().rstrip().split()

    if command[0] == 'push':
        queue.append(command[1])

    elif command[0] == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue.pop(0))  # 지정된 위치의 값을 취득한 후 삭제, 리스트 인덱스는 0부터 다시 시작

    elif command[0] == 'size':
        print(len(queue))

    elif command[0] == 'empty':
        if not queue:
            print(1)
        else:
            print(0)

    elif command[0] == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])

    elif command[0] == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])
