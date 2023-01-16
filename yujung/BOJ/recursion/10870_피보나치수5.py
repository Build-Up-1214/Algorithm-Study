import sys
sys.setrecursionlimit(10**6)

n = int(input())

def recursive(i):
    if i == 0:
        return 0
    elif i == 1:
        return 1
    
    return recursive(i - 1) + recursive(i - 2)

print(recursive(n))