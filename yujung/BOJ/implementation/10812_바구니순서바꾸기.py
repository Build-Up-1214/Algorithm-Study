n, m = map(int, input().split())
bucket = list(range(1, n + 1))
for _ in range(m):
    i, j, k = map(int, input().split())
    bucket = bucket[:i-1] + bucket[k-1:j] + bucket[i-1:k-1] + bucket[j:]
print(*bucket)