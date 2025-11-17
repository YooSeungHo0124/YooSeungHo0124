from collections import deque
import math

def solution(progresses, speeds):
    days = deque()
    # 각 기능별 완성까지 필요한 일수 계산 후 덱에 저장
    for p, s in zip(progresses, speeds):
        time = math.ceil((100 - p) / s)
        days.append(time)

    answer = []
    while days:
        current = days.popleft()    # 맨 앞 기능 기준으로
        count = 1                  # 최소 1개 배포
        # 다음 기능도 앞 배포날짜와 같거나 작으면 묶어서 배포
        while days and days[0] <= current:
            days.popleft()
            count += 1
        answer.append(count)       # 묶음 개수 저장
    return answer
