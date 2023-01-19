def binary_search(array, start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        elif array[mid] < target:
            start = mid + 1
    return None

n = int(input())
nums = list(map(int, input().split()))

m = int(input())
m_nums = list(map(int, input().split()))

nums.sort()

for i in m_nums:
    if binary_search(nums, 0, n - 1, i) is not None:
        print(1, end = ' ')
    else:
        print(0, end = ' ')