n = int(input())
w = [int(input()) for _ in range(n)]
w.sort()
answer = []

for i in range(len(w)):
    answer.append(w[i] * (len(w) - i)) # 최소 중량 * 로프의 개수

print(max(answer))