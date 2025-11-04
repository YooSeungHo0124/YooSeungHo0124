import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> windowMap = new HashMap<>();
        int answer = 0;
        int windowSize = 10;
        
        // 초기 윈도우 세팅 (처음 10일)
        for (int i = 0; i < windowSize; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }
        if (windowMap.equals(wantMap)) answer++;
        
        // 슬라이딩 윈도우 이동
        for (int i = windowSize; i < discount.length; i++) {
            String removeItem = discount[i - windowSize];
            windowMap.put(removeItem, windowMap.get(removeItem) - 1);
            if (windowMap.get(removeItem) == 0) {
                windowMap.remove(removeItem);
            }
            
            String addItem = discount[i];
            windowMap.put(addItem, windowMap.getOrDefault(addItem, 0) + 1);
            
            if (windowMap.equals(wantMap)) answer++;
        }
        
        return answer;
    }
}
