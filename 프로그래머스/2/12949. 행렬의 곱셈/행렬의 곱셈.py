# arr1: m x n 행렬, arr2: n x r 행렬
# 결과 행렬 answer: m x r

def solution(arr1, arr2):
    m, n, r = len(arr1), len(arr1[0]), len(arr2[0])
    answer = [[0 for _ in range(r)] for _ in range(m)]
    for i in range(m):            # arr1의 행 인덱스
        for j in range(r):        # arr2의 열 인덱스
            for k in range(n):    # 곱 및 합산에 쓰는 인덱스
                answer[i][j] += arr1[i][k] * arr2[k][j]
    return answer
