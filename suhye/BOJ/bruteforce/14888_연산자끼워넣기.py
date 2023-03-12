import sys

n = int(sys.stdin.readline())

nums = list(map(int, sys.stdin.readline().split()))

# 순서대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
plus, minus, multiply, divide = map(int, sys.stdin.readline().split())

minRes = int(1e9)
maxRes = -int(1e9)


def calculate(i, res, plus, minus, multiply, divide):
    global maxRes, minRes

    if i == n:
        maxRes = max(maxRes, res)
        minRes = min(minRes, res)
        return
    if plus > 0:
        calculate(i+1, res+nums[i], plus-1, minus, multiply, divide)
    if minus > 0:
        calculate(i+1, res-nums[i], plus, minus-1, multiply, divide)
    if multiply > 0:
        calculate(i+1, res*nums[i], plus, minus, multiply-1, divide)
    if divide > 0:
        calculate(i+1, int(res/nums[i]), plus, minus, multiply, divide-1)


calculate(1, nums[0], plus, minus, multiply, divide)
print(maxRes)
print(minRes)



