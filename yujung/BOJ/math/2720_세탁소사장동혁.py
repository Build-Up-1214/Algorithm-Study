t = int(input()) # 테스트 케이스 개수
quarter = [25, 10, 5, 1]

for i in range(t):
    c = int(input())
    
    for q in quarter:
        print(int(c // q), end = ' ')
        c %= q
    print()