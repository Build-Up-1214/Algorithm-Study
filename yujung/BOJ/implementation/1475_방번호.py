room_num = input() # 다솜이의 방 번호
sticker = [0] * 10

for i in range(len(room_num)):
    n = int(room_num[i])
    if n == 6 or n == 9: # 6 혹은 9일 경우
        if sticker[6] <= sticker[9]: # 더 작은 수를 가지는 인덱스에 1을 더한다
            sticker[6] += 1
        else:
            sticker[9] += 1
    else:
        sticker[n] += 1 # 해당 인덱스에 1을 더한다

print(max(sticker)) # 가장 큰 값을 찾는다