def solution(number, k):
    stack = []
    for n in number:
        while stack and k > 0 and stack[-1] < n:
            stack.pop()
            k -= 1
        stack.append(n)

    if k > 0:
        stack = stack[:-k]
    return ''.join(stack)