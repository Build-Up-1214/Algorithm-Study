def solution(citations):
    
    citations.sort(reverse = True) # 내림차순 정렬
    answer = []
    
    for idx, val in enumerate(citations, start = 1):
        if idx <= val: # '인덱스 <= 인용 숫자'라면 조건에 부합
            answer.append(idx)
            
    if len(answer) == 0: # 원소가 하나인 경우, 모든 원소가 0인 경우
        return citations[0]
    
    return max(answer) # 가장 최대값을 구한다