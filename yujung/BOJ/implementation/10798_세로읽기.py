line = [list([0] * 15) for _ in range(5)] # 15개 * 5줄 자리 초기화

# 문자열 입력받아서 자리에 넣어 주기
for i in range(5):
    str = list(input())
    for j in range(len(str)):
        line[i][j] = str[j]

# 출력
for i in range(15):
    for j in range(5):
        if line[j][i] == 0: # 문자열 '0'이 자리한 경우에는 출력된다
            continue
        else:
            print(line[j][i], end = '')