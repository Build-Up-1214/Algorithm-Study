def recursion(s, i, r): # 문자열, 재귀 호출 횟수, 문자열 인덱스(뒤에서부터)
    global cnt
    cnt += 1
    if i >= r:
        return 1
    elif s[i] != s[r]:
        return 0
    return recursion(s, i + 1, r - 1)

def isPalindrome(s):
    return recursion(s, 0, len(s) - 1)

T = int(input())
for _ in range(T):
    cnt = 0
    print(isPalindrome(input()), cnt)