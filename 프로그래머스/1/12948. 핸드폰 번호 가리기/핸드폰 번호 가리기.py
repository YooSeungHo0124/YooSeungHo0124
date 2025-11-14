def solution(phone_number):
    masked = '*' * (len(phone_number) - 4)
    return masked + phone_number[-4:]