import sys

word = sys.stdin.readline().rstrip()
arr = [0]*26

for w in word:
    arr[ord(w)-97] += 1
for a in arr:
    print(a, end=' ')