import sys
input = sys.stdin.readline

# 정수 입력 받기
num = int(input())

if num == 1:
    print(1)
else:
    dp = [0, 1, 2]
    for i in range(3, num + 1):
        # num 값이 너무 크면 배열에 저장될 값이 int 값을 벗어나기 때문에, 반복문 안에서도 연산을 해주어야 메모리 초과가 발생하지 않는다.
        dp.append((dp[i - 1] + dp[i - 2]) % 10007)
    print(dp[num])