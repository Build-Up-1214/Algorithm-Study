from collections import deque

def solution(maps):

    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    # 최단거리: bfs
    def bfs(x, y):
        queue = deque()
        queue.append((x, y))

        while queue:

            x, y = queue.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]):
                    continue

                if maps[nx][ny] == 0:
                    continue

                elif maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    queue.append((nx, ny))

        if maps[len(maps) - 1][len(maps[0]) - 1] == 1:
            return -1

        return maps[len(maps) - 1][len(maps[0]) - 1]

    return bfs(0, 0)