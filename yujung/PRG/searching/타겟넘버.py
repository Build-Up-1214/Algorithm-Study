def solution(numbers, target):
    
    answer = 0
    
    # 모든 경우의 수 -> DFS
    # +이거나 -
    def dfs(numbers, target, depth, node_sum):
        if depth == len(numbers):
            if node_sum == target:
                nonlocal answer
                answer += 1
        else:
            dfs(numbers, target, depth + 1, node_sum + numbers[depth])
            dfs(numbers, target, depth + 1, node_sum - numbers[depth])
    
        return answer
    
    return dfs(numbers, target, 0, 0)