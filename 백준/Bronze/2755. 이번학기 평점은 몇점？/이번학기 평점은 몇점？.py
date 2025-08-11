import sys
from decimal import Decimal, ROUND_HALF_UP

input = sys.stdin.readline

grade_map = {
    "A+": Decimal('4.3'), "A0": Decimal('4.0'), "A-": Decimal('3.7'),
    "B+": Decimal('3.3'), "B0": Decimal('3.0'), "B-": Decimal('2.7'),
    "C+": Decimal('2.3'), "C0": Decimal('2.0'), "C-": Decimal('1.7'),
    "D+": Decimal('1.3'), "D0": Decimal('1.0'), "D-": Decimal('0.7'),
    "F":  Decimal('0.0')
}

n = int(input().strip())
total_credits = 0               # 정수로 유지해도 됨
total_score = Decimal('0')

for _ in range(n):
    _, credit_str, grade = input().split()
    credit = int(credit_str)
    total_credits += credit
    total_score += Decimal(credit) * grade_map[grade]

# 정확한 소수 연산 후 일반적 반올림 규칙(ROUND_HALF_UP)으로 둘째자리까지 반올림
avg = (total_score / Decimal(total_credits)).quantize(Decimal('0.00'), rounding=ROUND_HALF_UP)
print(f"{avg:.2f}")
