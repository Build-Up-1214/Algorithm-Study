n = int(input()) # 수열의 크기
n_list = list(map(int, input().split()))
x = int(input())

n_list.sort()
left, right = 0, n - 1 # 두 포인터를 둔다
answer = 0

while left < right: # 두 값이 만날 때까지 반복
    tmp = n_list[left] + n_list[right]
    if tmp == x: # 두 값을 더한 값이 x일 때
        answer += 1
    if tmp < x: # 두 값을 더한 값이 x보다 작으면 왼쪽 좌표를 오른쪽으로 옮긴다
        left += 1
    else:
        right -= 1 # 두 값을 더한 값이 x보다 크면 오른쪽 좌표를 오른쪽으로 옮긴다

print(answer)