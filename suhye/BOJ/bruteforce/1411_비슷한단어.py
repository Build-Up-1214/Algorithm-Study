import sys

n = int(sys.stdin.readline())
words = [sys.stdin.readline().strip() for _ in range(n)]

temp = [[] for _ in range(100)]
dic = [{} for _ in range(100)]
cnt = 0

# 단어 리스트 순회
for i in range(n):
    num = 0
    # 단어의 알파벳 순회
    for j in words[i]:
        if j not in dic[i]:
            # 새로운 알파벳일 경우, dic에 순서를 나타내는 수와 같이 추가
            dic[i][j] = str(num)
            num += 1
        # temp의 i번째 단어에 dic[i][j] 추가
        temp[i] += dic[i][j]

# 같은 단어인지 판별 후 카운트
for i in range(n):
    for j in range(i+1, n):
        if temp[i] == temp[j]:
            cnt += 1

print(cnt)

