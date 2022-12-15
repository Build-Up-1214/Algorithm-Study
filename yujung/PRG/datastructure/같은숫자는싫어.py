def solution(arr):
    
    answer = []
    answer.append(arr[0]) # 첫 번째 요소를 스택에 넣는다
    
    for i in range(1, len(arr)): # 두 번째 요소부터 마지막 요소까지 반복한다
        if arr[i] == arr[i - 1]: # 현재 요소가 이전 요소와 같을 경우 넘어간다
            continue
        else:
            answer.append(arr[i]) # 현재 요소가 이전 요소와 다를 경우 스택에 넣는다
    
    return answer