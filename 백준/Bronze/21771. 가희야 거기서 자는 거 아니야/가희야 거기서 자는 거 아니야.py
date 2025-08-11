import sys
input = sys.stdin.readline

R, C = map(int, input().split())
GR, GC, PR, PC = map(int, input().split())

room = [input().strip() for _ in range(R)]

# 베개 위치: PR x PC 크기, (PR, PC)의 시작점 찾기
# P의 전체 개수 세기
pillow_total = PR * PC
count_P = 0

for i in range(R):
    count_P += room[i].count('P')

# 만약 전체 P의 개수가 베개의 넓이와 정확히 같으면 가희는 베개 위가 아님
# 아닌 경우 가희가 베개 위에 있는 것(겹쳐져서 P가 줄어듦)
if count_P < pillow_total:
    print(1)
else:
    print(0)
