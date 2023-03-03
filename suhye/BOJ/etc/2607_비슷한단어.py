import sys

n = int(sys.stdin.readline())
first = list(sys.stdin.readline().strip())
words = [sys.stdin.readline().strip() for _ in range(n-1)]

ans = 0
for word in words:
    copy = first[:]
    cnt = 0
    for w in word:
        if w in copy:
            copy.remove(w)
        else:
            cnt += 1
    if cnt < 2 and len(copy) < 2:
        ans += 1

print(ans)
