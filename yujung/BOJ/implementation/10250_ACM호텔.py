t = int(input()) # 테스트 수
while t > 0:
    h, w, n = map(int, input().split()) # 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지
    f = n % h # 층 번호
    r = n // h + 1 # 방 번호
    if f == 0: # 제일 윗 층인 경우 (나머지가 0)
        f = h
        r -= 1 # 그 다음 층으로 넘어가지 않음
    print(f * 100 + r)
    t -= 1