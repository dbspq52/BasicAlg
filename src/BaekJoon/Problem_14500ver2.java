package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Problem_14500ver2 {
    int[][] MATRIX;
    boolean[][] checkMatrix;
    int MAX2 = 0;
    int N2;
    int M2;

    public Problem_14500ver2() throws IOException {
        initMatrix();
        for(int i = 0; i < N2; i++){
            for(int j = 0; j < M2; j++){
                deepResearchWithRecursion2(j, i, MATRIX, checkMatrix, new ArrayList<>(), 0);
                checkFuck(j,i,MATRIX);
            }
        }
        System.out.println(MAX2);
    }

    private void initMatrix() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());

        //체크 행렬 초기화
        checkMatrix = new boolean[N2][M2];
        //행렬 값 주입
        MATRIX = new int[N2][M2];
        for (int i = 0; i < N2; i++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            while(st.hasMoreTokens()){
                MATRIX[i][index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }
    }
    private void deepResearchWithRecursion2(int x, int y, int[][] MATRIX, boolean[][]checkMatrix,List<Integer> bowl, int depth) {
        if (depth == 4) {
            int sum = 0;
            sum = bowl.stream().mapToInt(Integer::intValue).sum();
            if(MAX2 <= sum){
                MAX2 = sum;
            }
            return;
        }

        if((x >=0 && x < M2) && (y >=0 && y < N2) && !checkMatrix[y][x]) {
            checkMatrix[y][x] = true;
            bowl.add(MATRIX[y][x]);
            deepResearchWithRecursion2(x + 1, y, MATRIX,checkMatrix, bowl,depth + 1);
            deepResearchWithRecursion2(x - 1, y, MATRIX,checkMatrix, bowl,depth + 1);
            deepResearchWithRecursion2(x, y + 1, MATRIX,checkMatrix, bowl,depth + 1);
            deepResearchWithRecursion2(x, y - 1, MATRIX,checkMatrix, bowl,depth + 1);
            bowl.remove(bowl.size() -1);
            checkMatrix[y][x] = false;
        }

    }

    private void checkFuck(int x, int y, int[][]MATRIX){
        int[][][] dxdy= {{{-1, 0}, {0,1}, {1,0}},
                        {{1,0},{0,1},{0,-1}},
                        {{-1,0},{1,0},{0,-1}},
                        {{-1,0},{0,1},{0,-1}}};
        for(int[][] fuck : dxdy){
            int x1 = x - fuck[0][0];
            int y1 = y - fuck[0][1];

            int x2 = x - fuck[1][0];
            int y2 = y - fuck[1][1];

            int x3 = x - fuck[2][0];
            int y3 = y - fuck[2][1];
            if(checkBoundary(x1,y1) && checkBoundary(x2,y2) && checkBoundary(x3,y3)){
                int sum = MATRIX[y1][x1] + MATRIX[y2][x2] + MATRIX[y3][x3] + MATRIX[y][x];
                if(MAX2 <= sum){
                    MAX2 = sum;
                }
            }
        }
    }
    private boolean checkBoundary(int x, int y){
        return (x >= 0 && x < M2) && (y >= 0 && y < N2);
    }
}
