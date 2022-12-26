class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        
        max_list = []
        answer = 0
        
        while grid[0]: # 내부 리스트에 원소가 존재하지 않을 때까지 반복

            for i in grid:
                i.sort()
            
            for i in grid:
                max_list.append(i[-1]) # 가장 큰 수를 리스트에 저장하고 꺼낸다
                i.pop()
        
            answer += max(max_list) # 뽑아낸 각 리스트들의 큰 값 중에서도 가장 큰 값을 누적해서 더한다
            max_list.clear() # 다음 반복 이전에 리스트를 비운다
        
        return answer