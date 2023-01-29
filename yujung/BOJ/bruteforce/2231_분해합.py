n = int(input())
n_sum = 0

for i in range(1, n + 1):
    i_sum = sum(map(int, str(i))) # i의 각 자리수의 합
    n_sum = i + i_sum # 분해합
    
    if n_sum == n: # 분해합이 n과 같을 때
        print(i) # 생성자 출력
        break
    elif i == n: # 반복문이 n번까지 반복됐을 때, 생성자를 찾지 못했다는 의미
        print(0)
        break