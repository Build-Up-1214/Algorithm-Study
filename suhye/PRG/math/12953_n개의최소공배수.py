from math import gcd
def solution(arr):
    # 최소공배수 = (x*y) / 최소공약수(x,y)
    ans = arr[0]
    for num in arr:
        ans = ans * num // gcd(ans, num)
    return ans