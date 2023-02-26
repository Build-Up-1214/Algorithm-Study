import sys
input = sys.stdin.readline

t = int(input()) # 테스트 케이스 개수
for i in range(t):
    n = int(input()) # 지원자의 숫자
    n_list = [list(map(int, input().split())) for _ in range(n)]
    n_list.sort() # 서류 순위로 정렬
    
    i_best = n_list[0][1] # 서류 순위 i등의 면접 점수보다 i + 1의 면접 점수가 더 크면 합격
    answer = 1 # 서류 순위 1등
    for i in range(1, len(n_list)):
        if i_best > n_list[i][1]:
            i_best = n_list[i][1]
            answer += 1
    print(answer)