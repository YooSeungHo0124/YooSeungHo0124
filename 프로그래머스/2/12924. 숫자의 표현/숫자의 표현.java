class Solution {
    public int solution(int n) {
        int cnt =0;
        
        for (int i=1; i<=n; i++) {
            int count = i;
            int sum =0;
            while (sum <= n) {
                // 자연수 합이 n이 된 경우
                if (sum == n ) cnt++;
                
                sum += count;
                
                // 아니면 count 1추가
                count++;
                
            }
            
        }
    
        
        
        
        return cnt;
    }
}