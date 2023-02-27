# 에라토스테네스의 체
m, n = map(int, input().split())

sieve = [True] * (n + 1) # 처음에는 모두 소수로 간주
sieve[0], sieve[1] = False, False

for i in range(2, int(n ** 0.5) + 1): # 2부터 시작
    if sieve[i]:
        for j in range(i + i, n + 1, i): # i 배수들을 모두 False로 변경(어떤 수로 나눠지면 소수가 아님)
            sieve[j] = False

for i in range(m, n + 1): # 1 포함 X
    if sieve[i] == True:
        print(i)