def solution(n):
    digits = [x for x in str(n)]
    digits.sort(reverse = True)
    return int(''.join(digits))