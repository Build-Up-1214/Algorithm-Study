n, b = map(int, input().split()) # 10진법 수, b진법

nums = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
answer = ''

while n:
    answer = nums[n % b] + answer
    n //= b

print(answer)