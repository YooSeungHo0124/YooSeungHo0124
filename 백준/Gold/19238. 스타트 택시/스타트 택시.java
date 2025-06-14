import java.util.*;
import java.io.*;

public class Main {
        static int N, M, fuel, taxiY, taxiX;
        static int[][] map;
        static int[] dy = {-1, 1, 0, 0};
        static int[] dx = {0, 0, -1, 1};
        // 승객 정보: 출발지(y,x), 목적지(y,x)
        static int[][] passInfo; // [i][0~1]: 출발지 y,x, [i][2~3]: 목적지 y,x

        // BFS 탐색 노드 (위치, 거리)
        static class Node implements Comparable<Node> {
            int y, x, dist;
            Node(int y, int x, int dist) {
                this.y = y;
                this.x = x;
                this.dist = dist;
            }
            @Override
            public int compareTo(Node o) {
                if (this.dist != o.dist) return Integer.compare(this.dist, o.dist);
                if (this.y != o.y) return Integer.compare(this.y, o.y);
                return Integer.compare(this.x, o.x);
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            fuel = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            taxiY = Integer.parseInt(st.nextToken()) - 1;
            taxiX = Integer.parseInt(st.nextToken()) - 1;

            passInfo = new int[M][4];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int sy = Integer.parseInt(st.nextToken()) - 1;
                int sx = Integer.parseInt(st.nextToken()) - 1;
                int ey = Integer.parseInt(st.nextToken()) - 1;
                int ex = Integer.parseInt(st.nextToken()) - 1;
                passInfo[i][0] = sy;
                passInfo[i][1] = sx;
                passInfo[i][2] = ey;
                passInfo[i][3] = ex;
                map[sy][sx] = i + 2; // 승객 번호: 2, 3, ..., M+1
            }

            int cnt = 0;
            while (cnt < M) {
                // 1. 가장 가까운 승객 찾기 (우선순위: 거리 → 행 → 열)
                PriorityQueue<Node> pq = new PriorityQueue<>();
                boolean[][] visited = new boolean[N][N];
                pq.add(new Node(taxiY, taxiX, 0));
                visited[taxiY][taxiX] = true;

                int select = -1;
                while (!pq.isEmpty()) {
                    Node node = pq.poll();
                    if (map[node.y][node.x] >= 2) {
                        select = map[node.y][node.x] - 2;
                        taxiY = node.y;
                        taxiX = node.x;
                        fuel -= node.dist;
                        break;
                    }
                    for (int d = 0; d < 4; d++) {
                        int ny = node.y + dy[d];
                        int nx = node.x + dx[d];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == 1)
                            continue;
                        visited[ny][nx] = true;
                        pq.add(new Node(ny, nx, node.dist + 1));
                    }
                }
                if (select == -1 || fuel < 0) {
                    System.out.println(-1);
                    return;
                }
                map[taxiY][taxiX] = 0;

                // 2. 목적지까지 이동
                int ey = passInfo[select][2];
                int ex = passInfo[select][3];
                visited = new boolean[N][N];
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(taxiY, taxiX, 0));
                visited[taxiY][taxiX] = true;

                boolean found = false;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    if (node.y == ey && node.x == ex) {
                        taxiY = node.y;
                        taxiX = node.x;
                        fuel -= node.dist;
                        if (fuel < 0) {
                            System.out.println(-1);
                            return;
                        }
                        fuel += node.dist * 2;
                        found = true;
                        break;
                    }
                    for (int d = 0; d < 4; d++) {
                        int ny = node.y + dy[d];
                        int nx = node.x + dx[d];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == 1)
                            continue;
                        visited[ny][nx] = true;
                        q.add(new Node(ny, nx, node.dist + 1));
                    }
                }
                if (!found) {
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }
            System.out.println(fuel);
        }
    }
