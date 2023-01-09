import sys
input = sys.stdin.readline

n = int(input())
tree = {}

for i in range(n):
    root, left, right = input().rstrip().split()
    # 파이썬으로 트리 구현하는 방법 : dictionary 사용
    # root를 key로, left, rignt를 value로 할당
    tree[root] = [left, right]


# 한번 재귀할 때마다 탐색을 한번 더 하는 의미로 받아들이기
# 함수 안의 ~~order(tree[root][0]) 재귀함수는 왼쪽으로 끝까지 탐색한다는 의미
# 함수 안의 ~~order(tree[root][1]) 재귀함수는 오른쪽으로 끝까지 탐색한다는 의미
# root -> 출력

# 1. 전위 순회 : 루트 -> 왼쪽 자식 -> 오른쪽 자식 (재귀함수의 순서 : root 출력 -> 왼쪽 재귀함수 -> 오른쪽 재귀함수)
def preorder(root):
    if root != ".":
        print(root, end="")    # root
        preorder(tree[root][0])    # left
        preorder(tree[root][1])    # right


# 2. 중위 순회 : 왼쪽 자식 -> 루트 -> 오른쪽 자식 (재귀 함수의 순서 : 왼쪽 재귀함수 -> root 출력문 -> 오른쪽 재귀함수)
def inorder(root):
    if root != ".":
        inorder(tree[root][0])    # left
        print(root, end="")    # root
        inorder(tree[root][1])    # right


# 3. 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 루트 (재귀 함수의 순서 : 왼쪽 재귀함수 -> 오른쪽 재귀함수 -> root 출력문)
def postorder(root):
    if root != ".":
        postorder(tree[root][0])    # left
        postorder(tree[root][1])    # right
        print(root, end="")    # root


preorder("A")
print()
inorder("A")
print()
postorder("A")