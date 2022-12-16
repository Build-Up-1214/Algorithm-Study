def solution(participant, completion):
    
    hashDict = {}
    sumHash = 0
    
    for i in participant:
        hashDict[hash(i)] = i # Key: 참여자 이름의 해시값, Value: 이름
        sumHash += hash(i) # 해시값 누적합
    
    for j in completion:
        sumHash -= hash(j) # 해시값 누적합에서 완주한 선수들의 해시값을 뺀다
    
    return hashDict[sumHash] # 남은 해시값과 일치하는 Key의 Value가 완주하지 못한 선수의 이름이다
    