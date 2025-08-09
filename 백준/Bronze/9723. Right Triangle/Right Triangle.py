import sys
input = sys.stdin.readline

T = int(input())
for case_num in range(1, T+1) :
    a, b, c = map(int, input().split())
    sides = sorted([a, b, c])
    if sides[2]**2 == sides[0]**2 + sides[1]**2 :
        result = "YES"
    else :
        result = "NO"
    
    print(f"Case #{case_num}: {result}")
