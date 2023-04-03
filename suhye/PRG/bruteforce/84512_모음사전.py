from itertools import product
def solution(word):
    answers = []
    for i in range(1, 6):
        for p in product(['A', 'E', 'I', 'O', 'U'], repeat = i):
            answers.append(''.join(p))
    answers.sort()
    return answers.index(word) + 1