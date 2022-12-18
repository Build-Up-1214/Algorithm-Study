t = int(input())

def bracket_stack(bracket):
    stack = []
    for s in bracket:
        if s == '(':
            stack.append('(')
        elif s == ')': # 닫는 괄호는 열린 괄호가 이미 존재해야 성립한다
            if len(stack) == 0:
                return "NO"
            else:
                stack.pop()
                
    if len(stack) == 0: # 괄호들이 짝이 맞을 경우 스택에 남아 있는 괄호가 없어야 한다
        return "YES"
    else:
        return "NO"

for _ in range(t):
    bracket = input()
    print(bracket_stack(bracket))