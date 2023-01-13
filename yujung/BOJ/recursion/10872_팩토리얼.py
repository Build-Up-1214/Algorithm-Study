import sys
sys.setrecursionlimit(10**6)

N = int(input())

def recursion(n):
    if n <= 1:
        return 1
    return n * recursion(n - 1)

print(recursion(N))