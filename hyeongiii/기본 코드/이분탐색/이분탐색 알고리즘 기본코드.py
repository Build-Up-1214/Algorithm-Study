# 비재귀적 이분 탐색의 파이썬 코드 (반복문)
def binary_search(arr, val):
    start, end = 0, arr.len()
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == val:
            return mid
        elif arr[mid] > val:
            end = mid - 1
        else:
            start = mid + 1

    return -1


# arr은 오름차순으로 정렬된 리스트
def binary_search(arr, target, low=None, high=None):
    low, high = low or 0, high or len(arr) - 1
    if low > high:
        return -1
    mid = (low + high) // 2
    if arr[mid] > target:
        return binary_search(arr, target, low, mid)
    if arr[mid] == target:
        return mid
    if arr[mid] < target:
        return binary_search(arr, target, mid + 1, high)