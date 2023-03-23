def solution(n, lost, reserve):
    # 바로 앞번호나 뒷번호의 학생에게만 빌려줄 수 있다.
    # set을 이용해 공통요소 제거
    reserve_del = set(reserve) - set(lost)
    lost_del = set(lost) - set(reserve)
    for i in reserve_del:
        if i-1 in lost_del:
            lost_del.remove(i-1)
        elif i+1 in lost_del:
            lost_del.remove(i+1)
    return n - len(lost_del)