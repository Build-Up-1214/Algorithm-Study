total = 0 # 학점의 총합
answer = 0 # (학점 x 과목평점) 합
g = ['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', 'F']
s = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0]

for _ in range(20):
    subject, score, grade = input().split()
    score = float(score)
    
    if grade != 'P':
        total += score
        answer += score * s[g.index(grade)]

print(answer / total)