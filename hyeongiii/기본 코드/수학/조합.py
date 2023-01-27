# 1. 재귀 함수를 이용한 조합
def comb(arr, n):
    result = []
    if n > len(arr):
        return result

    if n == 1:
        for i in arr:
            result.append([i])

    elif n > 1 :
        for i in range(len(arr) - n + 1):
            for j in comb(arr[i + 1:], n -1):
                result.append([arr[i]] + j)

    return result
    # arr = [1, 2, 3]
    # print(comb(arr, 3))  -> [[1, 2], [1, 3], [2, 3]]


# 2. itertools 내장 함수를 통해 구하기 (라이브러리 이용이 훨씬 빠름)
import itertools

data = [1, 2, 3, 4, 5]

for i in itertools.combinations(data, 3):
    print(list(i), end = ' ')