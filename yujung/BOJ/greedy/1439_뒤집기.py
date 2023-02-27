s = input()
answer = 0
for i in range(1, len(s)):
    if s[i - 1] != s[i]:
        answer += 1
print((answer + 1) // 2) # answer가 홀수일 경우를 대비하여 1을 더해 주고, 0 또는 1 중 하나만 바꾸면 되므로 // 2