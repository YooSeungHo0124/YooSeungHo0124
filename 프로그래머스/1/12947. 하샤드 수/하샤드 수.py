def solution(x):
    sumX = sum([int(i) for i in str(x)])
    return True if x%sumX == 0 else False
    