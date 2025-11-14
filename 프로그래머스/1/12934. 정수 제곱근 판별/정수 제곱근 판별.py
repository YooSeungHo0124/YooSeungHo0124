import math

def solution(n):
    root = int(math.sqrt(n))
    if root * root == n:
        return (root + 1) ** 2
    else:
        return -1
