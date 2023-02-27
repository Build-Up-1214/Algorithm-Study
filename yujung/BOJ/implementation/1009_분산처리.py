import sys
input = sys.stdin.readline

t = int(input()) # 테스트 케이스 개수
for _ in range(t):
    a, b = map(int, input().split()) # a^b
    aa = a % 10
    
    # 일의 자리 값의 반복 규칙에 따라 반복문 나눔
    if aa == 0:
        print(10)
    elif aa in [1, 5, 6]:
        print(aa)
    elif aa in [4, 9]:
        if b % 2 == 0:
            print(aa ** 2 % 10)
        else:
            print(aa)
    else:
        if b % 4 == 0:
            print(aa ** 4 % 10)
        else:
            print(aa ** (b % 4) % 10)