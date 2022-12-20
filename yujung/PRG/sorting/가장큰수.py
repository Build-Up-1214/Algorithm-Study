def solution(numbers):
    
    numbers_str = [str(x) for x in numbers] # 숫자의 앞자리로 비교하기 위해 문자열로 바꿔서 저장
    # Key: 람다를 통해 문자열 * 3(숫자에 0이 들어갈 경우 고려), 내림차순 정렬
    numbers_str.sort(key = lambda x: x * 3, reverse = True) # sort() 내부는 정렬 방식일 뿐이다
    answer = "".join(numbers_str)
    
    return str(int(answer)) # int로 감싸서 결과가 0000과 같은 경우를 0로 바꿈