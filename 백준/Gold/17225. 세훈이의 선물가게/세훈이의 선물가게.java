import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int b_time = Integer.parseInt(st.nextToken()); // 파란색 포장 시간
        int r_time = Integer.parseInt(st.nextToken()); // 빨간색 포장 시간
        int N = Integer.parseInt(st.nextToken()); // 손님 수

        // 0 : start , 1 : color (0은 BLUE 1은 RED)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            // 값이 같다면  : 블루 우선
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            // 값이 다르면 : 작은 숫자부터
            else {
                return a[0] - b[0] ;
            }
        });

        // 포장
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 주문 시각
            int c = st.nextToken().equals("B") ? 0 : 1 ;
            int m = Integer.parseInt(st.nextToken()); // 주문 개수

            int gap = c == 0 ? b_time : r_time;     // 색에 따른 포장시간

            for (int j=0; j<m; j++) {
                pq.offer(new int[] {t+j*gap,c});
            }
        }

        // 결과 카운팅
        ArrayList<Integer> b_count = new ArrayList<>();
        ArrayList<Integer> r_count = new ArrayList<>();

        int cnt = 1;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int color = tmp[1];

            if (color == 0) {
                b_count.add(cnt++);
            }
            else if (color == 1) {
                r_count.add(cnt++);
            }

        }

        // 출력
        System.out.println(b_count.size());
        for (int i=0; i<b_count.size(); i++) {
            System.out.print(b_count.get(i)+" ");
        }
        System.out.println();

        System.out.println(r_count.size());
        for (int i=0; i<r_count.size(); i++) {
            System.out.print(r_count.get(i)+" ");
        }

    }

}
