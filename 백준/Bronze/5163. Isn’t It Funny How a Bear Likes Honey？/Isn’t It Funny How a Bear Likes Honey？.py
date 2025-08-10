import sys
import math

input = sys.stdin.readline

K = int(input())  # 데이터 세트 개수
for case in range(1, K + 1):
    b, w = input().split()
    b = int(b)
    w = float(w)

    total_lift = 0.0  # 총 부력(그램)
    for _ in range(b):
        r = float(input())  # 풍선 반지름(cm)
        volume_cm3 = (4.0 / 3.0) * math.pi * (r ** 3)  # 부피(cm³)
        lift_grams = volume_cm3 / 1000.0  # 1000cm³당 1g 들어올림
        total_lift += lift_grams

    print(f"Data Set {case}:")
    if total_lift > w:
        print("Yes")
    else:
        print("No")
    print()
