def solution(nums):
    
    answer = 0
    hashDict = {}
    
    for i in nums:
        hashDict[i] = 1 # 중복이 허용되지 않도록 저장
    
    choice = len(nums) // 2 # 선택할 수 있는 수
    dictSize = len(hashDict) # 폰켓몬의 종류
    
    if choice > dictSize: # 만약 선택할 수 있는 수가 폰켓몬의 종류보다 크다면
        answer = dictSize # 폰켓몬의 종류의 수만큼 선택할 수 있다
    else: # 그렇지 않다면
        answer = choice # 선택할 수 있는 수만큼 선택할 수 있다
    
    return answer