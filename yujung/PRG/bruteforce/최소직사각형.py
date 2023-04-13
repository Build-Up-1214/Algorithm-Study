def solution(sizes):
    # 가로 세로를 비교하여 가장 긴 길이 * 가로 세로를 비교해서 더 짧은 길이들 중에서 가장 긴 길이
    return max(max(i) for i in sizes) * max(min(i) for i in sizes)