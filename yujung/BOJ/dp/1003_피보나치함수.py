zero = [1, 0, 1]
one = [0, 1, 1]

def fibonacci(n):
    if n >= len(zero): # n이 계산되지 않은 값일 때
        for i in range(len(zero), n + 1):
            # fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
            # 피보나치 n에서 0, 1 호출 횟수 = (피보나치 n - 1에서 0, 1 호출 횟수) + (피보나치 n - 2에서 0, 1 호출 횟수)
            zero.append(zero[i - 1] + zero[i - 2])
            one.append(one[i - 1] + one[i - 2])
    print('{} {}'.format(zero[n], one[n]))

t = int(input()) # 테스트 케이스 개수
for i in range(t):
    n = int(input())
    fibonacci(n)