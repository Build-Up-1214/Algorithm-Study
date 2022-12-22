import sys

N = int(sys.stdin.readline())
N_list = list(map(int, sys.stdin.readline().split()))

sort_list = sorted(set(N_list)) # set으로 중복을 제거하고 정렬한다 -> list로 변환된다

"""
list.index(i): 시간 복잡도 O(N)으로, 시간 초과 발생

for i in range(N):
    print(sort_list.index(N_list[i]), end = " ") # N_list의 값의 인덱스가 압축한 좌표이다
"""

dick = {val : index for index, val in enumerate(sort_list)} # 딕셔너리로 Key: 값, Value: 인덱스 저장
for n in N_list: # 값으로 인덱스를 찾는다
    print(dick[n], end = " ")