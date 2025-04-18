package Chapter6_Recursion;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameBoard {
    // 4가지 타입의 시작 블록
    static int[][][] coverType = {
            {{0,0},{1,0},{0,1}}, //┌
            {{0,0},{0,1},{1,1}}, //┐
            {{0,0},{1,0},{1,1}}, //└
            {{0,0},{1,0},{1,-1}} //┘
    };

    // 각각 높이, 넓이,흰칸의 수, 게임판, 경우의 수
    static int H,W, wc, ans;
    static int[][] board;

    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public GameBoard() throws IOException {
        int C = Integer.parseInt(sc.readLine());

        for(int i=0; i<C; i++) {
            st = new StringTokenizer(sc.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 흰색 칸의 수와 보드 초기화
            wc=0;
            board = new int[H][W];

            // board판에 흰색과 검은색을 채워 넣는 과정
            for(int y=0; y<H; y++) {
                st = new StringTokenizer(sc.readLine());
                for(int x=0; x<W; x++) {
                    String tmp = st.nextToken();

                    // 흰색 칸은 0, 검은색 칸은 1
                    board[y][x] = tmp.equals(".") ? 0:1;

                    if(board[y][x]==0) {
                        wc++;
                    }
                }
            }

            // solve()를 호출하는 과정
            // 3의 배수라면 호출
            // 아니면 0 출력
            ans=0;
            if(wc%3==0) {
                solve(wc);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    // 모든 경우의 수를 구해보는 핵심 메서드
    static void solve(int WC) {

        // 기저사례(1): 하나의 경우의 수를 찾은 경우

        if (WC == 0) {
            ans++;
            return;
        }

        for(int y=0; y<H; y++) {
            for(int x=0; x<W; x++) {
                if(board[y][x]==0) {
                    for(int k=0; k<4; k++) {
                        if(check(k, y, x)) {
                            set(k, y, x, 1);
                            solve(WC-3);
                            set(k,y,x,0);
                        }
                    }
                    return;
                }
            }
        }
    }

    // coverType 4가지가 보드판에 맞는지 확인하는 메서드
    static boolean check(int k, int y, int x) {
        for(int i=0; i<3; i++) {
            int ny = y + coverType[k][i][0];
            int nx = x + coverType[k][i][1];

            if(!inRange(ny, nx) || board[ny][nx]==1) {
                return false;
            }
        }
        return true;
    }

    // 보드판 범위에 포함하는 지 확인하는 메서드
    static boolean inRange(int ny, int nx) {
        return (ny>=0 && ny<H) && (nx>=0 && nx<W);
    }

    // 보드판에 흰색(0) 또는 검은색(1)으로 설정하는 메서드
    static void set(int k, int y, int x, int c) {
        for(int i=0; i<3; i++) {
            int ny = y + coverType[k][i][0];
            int nx = x + coverType[k][i][1];
            board[ny][nx] = c;
        }
    }
}
