import java.util.*;
import java.io.*;

public class Main {

    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // map 입력
        char[][] map = new char[R][S];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            char[] charArray = st.nextToken().toCharArray();
            for (int j=0; j<S; j++) {
                map[i][j] = charArray[j];
            }
        }

        // 카운팅
        // 악수 카운팅
        int result =0;

        // 추가 자리 있다면 add 만큼 최종값에 더하기
        int add = 0;

        for (int i=0; i<R; i++) {
            for (int j=0; j<S; j++) {

                // add를 위한 추가 카운팅
                int prob =0;

                 for (int k=0; k<8; k++) {
                     // 8 방향에서 악수할 개수 확인하고
                     // 자신이 o 라면 개수 카운팅
                     // 아니라면 자리 파악

                     int nr = i + dr[k];
                     int nc = j + dc[k];

                     // 악수
                     if (0<= nr && nr <R && 0<=nc && nc < S &&    map[i][j] == 'o' && map[nr][nc] == 'o') {
                         result++;
                     }

                     else if (0<= nr && nr <R && 0<=nc && nc < S && map[i][j] == '.' && map[nr][nc] == 'o') {
                         prob++;
                     }

                 }

                 // add 업데이트
                 add = Math.max(add, prob);
            }
        }


        // 출력
        System.out.println(result/2 + add);
    }

}
