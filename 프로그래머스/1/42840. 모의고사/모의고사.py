def solution(answers):
    # 수포자들이 찍는 패턴
    p1 = [1,2,3,4,5]
    p2 = [2,1,2,3,2,4,2,5]
    p3 = [3,3,1,1,2,2,4,4,5,5]

    # 각 수포자가 맞힌 문제 개수
    scores = [0,0,0]

    for idx, answer in enumerate(answers):
        if answer == p1[idx % len(p1)]:
            scores[0] += 1
        if answer == p2[idx % len(p2)]:
            scores[1] += 1
        if answer == p3[idx % len(p3)]:
            scores[2] += 1

    # 가장 많이 맞힌 사람(여럿이면 오름차순)
    max_score = max(scores)
    return [i+1 for i, score in enumerate(scores) if score == max_score]
