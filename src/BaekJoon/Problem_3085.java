/**상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

 가장 처음에 N×N크기에 사탕을 채워 놓는다. 
 사탕의 색은 모두 같을 수도 있고 아닐 수 도 있고 모두 다를 수도 있다는 것.
 1. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다.
 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
 2.이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

 want = 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

 출력
 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
 * */
/**
 * 입력 구현,
 * Matrix 설정
 * 최대 개수를 구한다??->첫 바꾸는 시도를 바꾸어야 한다.
 * 다른 색을 찾고, 뭐라 해야 할까...
 **/

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Problem_3085 {
    String [][]arr;
    int N;
    int checkRow, checkCol;

    public Problem_3085() throws IOException {
        int apples1 = 0;
        int apples2 = 0;
        int MAX = 0;
        boolean isItChange = false;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.N = Integer.parseInt(br.readLine());
        arr = new String[this.N][this.N];
        input(this.N , br);
        //바꿀 때도 둘다를 해야하기 때문에 2개로 나뉘어야 한다...
        for(int i = 0 ; i < N; i++){
            for(int j = 0;  j < N; j ++){
                apples1 = 0;
                apples2 = 0;

                isItChange = pickAndSwapDifferentFeatRight(i , j);
                if(isItChange) {
                    apples1 = pickAndChooseSame();
                    goBackOriginal(i, j);
                }
                isItChange = pickAndSwapDifferentFeatDown(i , j);
                if(isItChange) {
                    apples2 = pickAndChooseSame();
                    goBackOriginal(i, j);
                }
                int apples = Math.max(apples1, apples2);
                if(MAX <= apples){
                    MAX = apples;
                }
            }
        }
        System.out.println(MAX);
    }
    private void input(int N, BufferedReader br) throws IOException{
        for(int i  = 0 ; i < N; i++){
            String input = br.readLine();
            String[] colors = input.split("");
            System.arraycopy(colors, 0, this.arr[i], 0, N);
        }
    }




    private boolean pickAndSwapDifferentFeatRight(int row, int col){
        if((col + 1 < N) && !Objects.equals(arr[row][col], arr[row][col + 1])){
            String tmp = arr[row][col];
            arr[row][col] = arr[row][col + 1];
            arr[row][col+1] = tmp;

            this.checkCol = col +1;
            this.checkRow = row;
            return true;
        }
        else{
            return false;
        }
    }

    private boolean pickAndSwapDifferentFeatDown(int row, int col){
        if((row + 1 <= N -1) && !Objects.equals(arr[row][col], arr[row + 1][col])){
            String tmp = arr[row][col];
            arr[row][col] = arr[row + 1][col];
            arr[row + 1][col] = tmp;

            this.checkCol = col;
            this.checkRow = row + 1;
            return true;
        }
        else{
            return false;
        }
    }




    private int pickAndChooseSame(){
        int max = 0;
        for(int i = 0; i < N; i++){
            int v1 = findRight(i);
            int v2 = findDown(i);
            int president = Math.max(v1, v2);
            if(max <= president){
                max = president;
            }
        }
        return max;
    }

    private int findRight(int row){
        int count = 1;
        int max = 0;
        for(int i = 0 ; i < N - 1; i++){
            if(Objects.equals(arr[row][i], arr[row][i + 1])){
                count +=1;
            }
            else{
                count = 1;
            }
            if(max <= count){
                max = count;
            }
        }
        return max;
    }
    private int findDown(int col){
        int count = 1;
        int max = 0;
        for(int i = 0;  i < N -1; i++){
            if(Objects.equals(arr[i][col], arr[i + 1][col])){
                count +=1;
            }
            else{
                count = 1;
            }
            if(max <= count){
                max = count;
            }
        }
        return max;
    }




    private void goBackOriginal(int row, int col){
        String tmp = arr[row][col];
        arr[row][col] = arr[checkRow][checkCol];
        arr[checkRow][checkCol] = tmp;
    }
}
