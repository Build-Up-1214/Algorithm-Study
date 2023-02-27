n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

answer = 0
for i in range(n):
    answer += max(a) * min(b)
    a.pop(a.index(max(a)))
    b.pop(b.index(min(b)))
 
print(answer)