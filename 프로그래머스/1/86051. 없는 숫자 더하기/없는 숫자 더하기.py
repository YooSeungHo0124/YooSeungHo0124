def solution(numbers):
    result =0
    
    for i in range(10):
        if (i in numbers) == False:
            result += i
        
    return result