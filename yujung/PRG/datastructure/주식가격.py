def solution(prices):
    answer = [0] * len(prices)
    
    for i in range(len(prices)):
        for j in range(i + 1, len(prices)):
            if prices[i] <= prices[j]: # 가격이 떨어지는 시점까지 반복하여 1를 더한다
                answer[i] += 1
            else:
                answer[i] += 1
                break
    
    return answer