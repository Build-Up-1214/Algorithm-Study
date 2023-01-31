def solution(answers):
    c1 = [1, 2, 3, 4, 5]
    c2 = [2, 1, 2, 3, 2, 4, 2, 5]
    c3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    score = [0, 0, 0]
    for idx, answer in enumerate(answers):
        if answer == c1[idx % len(c1)]:
            score[0] += 1
        if answer == c2[idx % len(c2)]:
            score[1] += 1
        if answer == c3[idx % len(c3)]:
            score[2] += 1
    
    answer = []
    for idx, s in enumerate(score):
        if s == max(score):
            answer.append(idx + 1)

    return answer