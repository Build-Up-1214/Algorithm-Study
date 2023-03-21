import operator

n = int(input()) # 하루 동안 팔린 책의 개수
book = dict()

for i in range(n):
    title = input()
    if title in book:
        book[title] += 1
    else:
        book[title] = 1

best_num = max(book.values())
book = sorted(book.items(), key = operator.itemgetter(0)) # 정렬하고자 하는 키 값을 1번째 인덱스 기준으로 한다
for b in book:
    if b[1] == best_num:
        print(b[0])
        exit(0)