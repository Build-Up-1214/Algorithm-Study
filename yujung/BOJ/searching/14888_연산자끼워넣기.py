n = int(input()) # 수의 개수
n_list = list(map(int, input().split())) # 수열
add, sub, mul, div = map(int, input().split()) # 연산자 개수
max_value = -1e9
min_value = 1e9

def dfs(i, arr): # 연산에 포함된 수의 개수, 수열에 포함된 수
    global add, sub, mul, div, max_value, min_value
    
    if i == n: # 주어진 수열을 다 활용했을 때, 최댓값 최소값 확인
        max_value = max(max_value, arr)
        min_value = min(min_value, arr)
    else:
        if add > 0:
            add -= 1
            dfs(i + 1, arr + n_list[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i + 1, arr - n_list[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i + 1, arr * n_list[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i + 1, int(arr / n_list[i]))
            div += 1

dfs(1, n_list[0])
print(max_value)
print(min_value)