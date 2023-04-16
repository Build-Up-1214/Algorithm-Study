def solution(i, j, k):
    answer = 0
    for n in range(i, j + 1):
        for m in str(n):
            if int(m) == k:
                answer += 1
    return answer