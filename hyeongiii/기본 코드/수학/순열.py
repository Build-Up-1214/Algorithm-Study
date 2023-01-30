# 1. 재귀 함수를 이용한 순열
def perm(arr, n):
    result = []
    if n > len(arr):
        return result

    if n == 1:
        for i in arr:
            result.append([i])

    elif n > 1:
        for i in range(len(arr)):
            ans = [i for i in arr]
            ans.remove(arr[i])
            for p in perm(ans, n - 1):
                result.append([arr[i]] + p)

    return result
    # arr = [1, 2, 3]
    # print(perm(arr, 3))    # [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

# 2. 기본 내장 함수를 이용하여 순열 구하기
import itertools

data = [1, 2, 3]

for i in itertools.permutations(data, 2):
    print(list(i), end = ' ')    # [1, 2] [1, 3] [2, 1] [2, 3] [3, 1] [3, 2]