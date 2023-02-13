""" 내가 푼 풀이 """
s = input()

zero = s.split('1')
one = s.split('0')

cnt_zero = len(zero) - zero.count('')
cnt_one = len(one) - one.count('')

if cnt_one > cnt_zero:
    print(cnt_zero)
else:
    print(cnt_one)


""" 책 풀이 """
data = input()
count0 = 0    # 전부 0으로 바꾸는 경우
count1 = 0    # 전부 1로 바꾸는 경우

# 첫 번째 원소에 대해서 처리
if data[0] == '1':
    count0 += 1
else:
    count1 += 1

# 두 번째 원소부터 모든 원소를 확인하며
for i in range(len(data) - 1):
    if data[i] != data[i + 1]:
        # 다음 수에서 1인 경우 (0으로 바꿔줘야 하는 경우)
        if data[i + 1] == '1':
            count0 += 1
        # 다음 수에서 0인 경우 (1로 바꿔줘야 하는 경우)
        else:
            count1 += 1
