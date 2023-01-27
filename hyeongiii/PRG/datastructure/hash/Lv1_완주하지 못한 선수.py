# 처음 풀이 (효율성 테스트에서 1개 실패)
# 해당 방식의 문제점 : list의 remove() 를 사용하여 값을 제거하는 것보다 index끼리 비교하는 연산이 훨씬 빠르다. -> remove()의 효율이 좋지 않다.
def solution(participant, completion):
    answer = set(participant) - set(completion)    # 차집합을 이용하여 중복되지 않는 선수 구하기

    if not answer:    # 집합으로 만들 당시, 참가자 중에 동명이인이 있어서 차집합이 null 일 경우
        for i in completion:
            participant.remove(i)
        return participant[0]

    return list(answer)[0]


# 정렬, loop를 사용한 답안
def solution(participant, completion):

    # 1. 두 list를 정렬한다.
    participant.sort()
    completion.sort()

    # completion 와 participant를 비교하여 다를 경우, 그 때의 i 값이 완주하지 못한 선수이다.
    for i, j in zip(participant, completion):
        if i != j:
            return i

    # 만약 completion을 다 순회하도록 i와 j가 같다면, 완주하지 못한 선수는 participant의 제일 마지막 인덱스에 있는 값이다.
    return participant[-1]


# collections 모듈 사용
'''
collections 모듈의 Counter
아이템의 발생 빈도를 카운트하여 {"아이템":발생빈도 } 형태로 dict형으로 저장한다.
Counter 끼리 뺄셈 연산이 가능하다.
'''
def solution(participant, completion):
    import collections

    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]


# hash 활용
def solution(participant, completion):
    answer = ''
    sumHash = 0
    dic = {}

    for part in participant:
        dic[hash(part)] = part
        sumHash += int(hash(part))

    for com in completion:
        sumHash -= hash(com)

    answer = dic[sumHash]

    return answer

'''
HashMap : key-value 짝을 이뤄 관리하는 클래스로, 이 문제에서 key는 hash한 값이고 value는 각 선수의 이름이다.
HashMap에 각 이름의 hash값을 구하고 'hashing'한 값을 모두 더한 것이 sumHash가 된다.

completion을 순회하며 각 이름들의 hash 값을 빼주면, 결국 완주하지 않은 선수의 hash 값만 남게 된다.
그 때, HashMap에서 해당 해시값을 key로 가진 이름을 반환하면 답이다.
'''