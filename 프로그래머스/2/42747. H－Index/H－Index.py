def solution(citations):
    citations.sort(reverse=True)   # 인용횟수 내림차순 정렬
    for i, c in enumerate(citations):  # i: 0부터 (논문 순번), c: 인용횟수
        if c < i+1:
            return i         # i개가 i 이상 인용
    return len(citations)   # 모든 논문이 횟수 이상이면 전체 논문 개수