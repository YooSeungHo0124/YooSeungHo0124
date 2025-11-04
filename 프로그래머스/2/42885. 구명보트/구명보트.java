import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int weight : people) {
            deque.add(weight);
        }
        
        int boatCount = 0;
        
        while (!deque.isEmpty()) {
            int heaviest = deque.removeLast();  // 가장 무거운 사람
            
            // 가장 가벼운 사람과 같이 탈 수 있는지 확인
            if (!deque.isEmpty() && deque.getFirst() + heaviest <= limit) {
                deque.removeFirst();  // 가장 가벼운 사람
            }
            
            boatCount++;
        }
        
        return boatCount;
    }
}