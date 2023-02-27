import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))

data.sort()
result = 0    # 총 그룹의 수
cnt = 0    # 현재 그룹의 모험가 수

for i in data:    # 공포도가 낮은 모험가부터 확인
    cnt += 1    # 현재 그룹에 해당 모험가를 포함시키기
    if cnt >= i:    # 현재 그룹 인원수가 모험가 공포도보다 크거나 같을 경우
        result += 1    # 그룹 확정, 총 그룹의 수를 증가시키기
        cnt = 0    # 현재 그룹에 포함된 모험가의 수 초기화

print(result)

