n = int(input()) # 숫자의 개수
nums = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

max_v = -1e9
min_v = 1e9

def dfs(i, arr):
    global add, sub, mul, div, max_v, min_v
    if i == n: # 하나의 식이 완성됐을 때
        max_v = max(max_v, arr)
        min_v = min(min_v, arr)
    else:
        if add > 0:
            add -= 1
            dfs(i + 1, arr + nums[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i + 1, arr - nums[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i + 1, arr * nums[i])
            mul += 1
        if add > 0:
            div -= 1
            dfs(i + 1, int(arr // nums[i]))
            div += 1

dfs(1, nums[0])
print(max_v)
print(min_v)