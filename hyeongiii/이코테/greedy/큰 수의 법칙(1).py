import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
data = list(map(int, input().rstrip().split()))

data.sort(reverse=True)
cnt = 0
answer = 0

while cnt < m:    # cnt가 m이 되면 반복문 종료
    if cnt + k <= m:
        answer += data[0] * k
        cnt += k

        if cnt < m:    # 만약, cnt가 m 보다 작을 경우, 큰수의 법칙을 지키기 위해 두번째로 큰 수를 더한다.
            answer += data[1]
            cnt += 1
    else:
        answer += data[0] * (m - cnt)

print(answer)