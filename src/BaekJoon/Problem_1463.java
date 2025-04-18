package BaekJoon;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 */

public class Problem_1463 {

    public Problem_1463() throws IOException {
        int N = input();
        int minRate = result(N, new int[N + 1]);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(minRate));
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    private int input()throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }
    private int result(int N, int[] dp) throws IOException{
        for(int i = 2 ; i  <= N ;i++){
            dp[i] = dp[i - 1] + 1;

            if(i % 2== 0){
                dp[i] = Math.min(dp[i], dp[i /2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[N];
    }

    //뺀다??? --> 형 변환  && 마무리(마지막이 2일때)
    //나눈다 --> 건너뛰기 어쩄든 1이기에(마지막이 3이면 나누기)

    //2와 3으로 나누어 떨어지지 않는자... = 소수
    //그렇다면..... 이 소수를... 어떻게???
    // 1. 횟수 관련 변수 --------- 1을 가장 빨리...
    //1 배수로 만드는게 가장 베스트
    //78-> 26 -> 13 -> 12 -> 4-> 2 -> 1
    //3을 쓰는게 가장 베스트
    //3이 배수인지 확인/
    //아니라면 뺀 값이 17 16 15 5 4 3 1
    //              17 16 8 4 3 1
}
