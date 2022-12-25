class Solution:
    def sortSentence(self, s: str) -> str:
        
        input_list = list(s.split())
        sort_dict = {}
        
        for i in input_list: # 딕셔너리 Key: index, Value: word
            sort_dict[i[-1]] = i[0:len(i) - 1]
        
        answer_sort = sorted(sort_dict.items()) # Value 값을 기준으로 정렬
        answer = ""
        
        for i in range(0, len(answer_sort)): # Value 값들로 문자열 만들기
            answer += answer_sort[i][1] + " "
        
        return answer[0:len(answer) - 1] # 마지막 공백 제거