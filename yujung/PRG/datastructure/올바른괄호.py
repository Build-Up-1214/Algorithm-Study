def solution(s):
    
    answer = True
    
    parenthesis = list(s) # 문자열를 구성하는 문자들을 하나하나 리스트에 담는다
    
    stack = []
    for i in parenthesis:
        if i == '(':
            stack.append('(')
        elif i == ')':
            if len(stack) == 0: # ')' 문자가 등장하기 이전에 스택에 '('가 존재해야 한다
                return False
            else:
                stack.pop() # ')' 문자가 등장하면 스택에 쌓인 '(' 문자를 스택에서 뽑아낸다
    
    if len(stack) != 0: # 모든 괄호가 짝이 맞은 경우 스택이 비어 있어야 한다
        return False

    return True