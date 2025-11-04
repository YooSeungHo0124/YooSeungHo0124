class Solution {
    public int solution(int n) {
        int battery = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                // 짝수면 순간이동 (건전지 소모 없음)
                n /= 2;
            } else {
                // 홀수면 한 칸 점프 (건전지 소모 1)
                n--;
                battery++;
            }
        }
        
        return battery;
    }
}
