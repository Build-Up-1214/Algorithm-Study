import sys
input = sys.stdin.readline

N = int(input())
card = list(map(int, input().rstrip().split()))
M = int(input())
data = list(map(int, input().rstrip().split()))

# 카드 정렬
card.sort()

# data의 인덱스를 순회
for i in range(len(data)):
    start = 0    # 인덱스 0부터
    end = len(card) - 1    # 마지막 인덱스까지
    tmp = 0
    while start <= end:
        mid = (start + end) // 2    # mid: 인덱스

        if card[mid] == data[i]:    # 카드와 데이터 값이 같으면 tmp값을 1로 설정한 뒤, 반복문 종료
            tmp = 1
            break

        # 이분 탐색
        if card[mid] > data[i]:
            end = mid - 1
        else:
            start = mid + 1

    if tmp == 1:
        print(1, end=" ")
    else:
        print(0, end=" ")


