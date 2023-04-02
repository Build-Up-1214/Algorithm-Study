def solution(n):
    cnt = bin(n).count('1')
    bigger = n + 1
    while True:
        if bin(bigger).count('1') == cnt:
            return bigger
        else:
            bigger += 1