def solution(k, dungeons):
    max_count = 0
    visited = [False] * len(dungeons)

    
    def backtrack(current_k, count):
        nonlocal max_count
        max_count = max(max_count, count)
        for i in range(len(dungeons)):
            if not visited[i]:
                required, consume = dungeons[i]
                if current_k >= required:
                    visited[i] = True
                    backtrack(current_k - consume, count + 1)
                    visited[i] = False
    backtrack(k, 0)
    return max_count
