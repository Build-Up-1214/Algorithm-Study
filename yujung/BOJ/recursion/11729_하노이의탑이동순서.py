def hanoi(n, start, end):
    if n == 1:
        print(start, end)
        return
    hanoi(n - 1, start, 6 - start - end) # 보조 막대로 옮긴다 (start와 end로 알아낸다)
    print(start, end)
    hanoi(n - 1, 6 - start - end, end) # 보조 막대에서 목표 막대로 옮긴다

N = int(input()) # 원판의 개수
print(2 ** N - 1)
hanoi(N, 1, 3)