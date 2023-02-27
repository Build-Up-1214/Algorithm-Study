import sys

n = int(sys.stdin.readline())

def isPalindrome(n):
    for i in range(len(n) // 2):
        if n[i] != n[-i-1]:
            return False
    return True

def isPrime(n):
    if n == 1: # 1은 소수가 아님
        return False
    for i in range(2, int(n**(1/2)) + 1): # 2부터 n의 제곱근까지
        if n % i == 0: # 나누어떨어질 경우 소수가 아님
            return False
    return True

while True:
    if isPalindrome(str(n)) and isPrime(n):
        break
    n += 1
print(n)


