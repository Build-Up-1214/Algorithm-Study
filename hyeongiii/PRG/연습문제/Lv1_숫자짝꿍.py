# 시간 초과
def solution(X, Y):
    tmp = []

    # x: 두 수 가운데 더 큰 값   y: 두 수 가운데 더 작은 값
    x = min(int(X), int(Y))
    y = max(int(X), int(Y))

    # 각각의 문자를 리스트로 변환
    a = list(str(x))
    b = list(str(y))

    # 더 작은(길이가 같거나 더 짧은) 배열을 순회하면서, 더 큰 배열과 중복되는 값이 있는지 확인
    for i in a:
        if i in b:
            b.remove(i)  # 중복되는 숫자를 제거
            tmp.append(i)  # 중복되는 숫자를 tmp에 저장

    # 중복되는 숫자가 없는 경우
    if len(tmp) == 0:
        return "-1"

    # 중복되는 숫자가 0 밖에 없는 경우
    if list(set(tmp)) == ["0"]:
        return "0"

    # 역순으로 정렬한 뒤, 반환
    tmp.sort(reverse=True)

    return "".join(tmp)


# 시간 초과 2
def solution(X, Y):
    a = set(list(X))
    b = set(list(Y))
    c = list(a & b)

    for i in c:
        if i != "0":
            for _ in range(min(list(X).count(i), list(Y).count(i)) - 1):
                c.append(i)

    if len(c) == 0:
        return "-1"
    elif c == ["0"]:
        return "0"
    else:
        c.sort(reverse=True)
        return "".join(c)


# 레퍼런스
def solution(X, Y):
    answer = ""

    # sort()를 사용하지 않고도 정렬하는 방법!!!
    for i in range(9, -1, -1):
        answer += str(i) * (min(X.count(str(i)), Y.count(str(i))))

    if len(answer) == 0:
        return "-1"
    elif len(answer) == answer.count("0"):
        return "0"
    else:
        return answer