def solution(before, after):
    sum1 = 0 # before의 아스키 코드
    sum2 = 0 # after의 아스키 코드
    for i in before:
        sum1 += ord(i)
    for i in after:
        sum2 += ord(i)
    return 1 if sum1 == sum2 else 0 # 둘의 아스키 코드의 합이 같은지 판별