import java.util.*;


class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = elements[i];
            extended[i + n] = elements[i];  // 배열을 두 배로 만들어 원형 효과
        }

        Set<Integer> sums = new HashSet<>();

        // 길이 1부터 n까지 연속 부분 수열 합 계산
        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = start; i < start + length; i++) {
                    sum += extended[i];
                }
                sums.add(sum);
            }
        }

        return sums.size();
    }
}
