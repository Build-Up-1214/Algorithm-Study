import sys

n = int(sys.stdin.readline()) # 가진 숫자 카드 개수
cards = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))

cards.sort()

for i in m_list:
    lt, rt = 0, n-1
    isExist = False
    while lt <= rt:
        mid = (lt + rt) // 2
        if cards[mid] == i:
            isExist = True
            print(1)
            break
        elif cards[mid] > i:
            rt = mid - 1
        else:
            lt = mid + 1
    if not isExist:
        print(0)