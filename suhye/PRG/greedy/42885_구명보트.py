def solution(people, limit):
    answer = 0
    people.sort()

    lt = 0
    rt = len(people) - 1
    while lt <= rt:
        if people[rt] + people[lt] <= limit:
            lt += 1
            rt -= 1
            answer += 1
        else:
            rt -= 1
            answer += 1
    return 