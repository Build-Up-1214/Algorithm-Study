class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        
        seats.sort() # 정렬
        students.sort()
        
        _sum = []
        
        for i in range(len(seats)): # 인덱스가 같은 두 원소의 차이를 리스트에 담는다
            _sum.append(abs(students[i] - seats[i]))
        
        return sum(_sum)
        