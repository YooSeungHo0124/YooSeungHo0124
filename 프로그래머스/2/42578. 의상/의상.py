def solution(clothes):
    kinds = {}
    for name, kind in clothes:
        kinds[kind] = kinds.get(kind, 0) + 1
    answer = 1
    for cnt in kinds.values():
        answer *= (cnt + 1)   # 각 종류의 옷을 "입지 않는 경우"도 포함
    return answer - 1         # 아무 옷도 입지 않는 경우 제외
    
    
    kinds = {}
    for name, kind in clothes:
        kinds[kind] = kinds.get(kind,0) + 1
    
    answer = 1
    for cnt in kinds.values():
        answer *= (cnt +1)
    return answer -1