package BaekJoon;

import java.io.*;

/**
 * 문제
 * 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 아래 그림은 2×17 직사각형을 채운 한가지 예이다.
 * 입력
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 * 출력
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 * 여기서 2 * 2를 뭐라 생각해야 할까??
 * 원래 2*2는 2개로 표현이 가능하잖아
 * 근데 JUSt 한개가 되는 것이지
 * 즉 2*2가 3개로 표현 가능하다
 *
 * n = 1 :  1,
 * n = 2 :  3,
 * n = 3 :  5,
 * n = 4 :  11,
 * n = 5 :  21,
 * n = 6 :  43,
 * n = 7 :  85,
 * n = 8 :  171
 * n = 9 :
 * n = 10:
 * n = 12 : 144 + a= 2731
 *공식!!!!!!!!!!!!!!!!!!!!!
 * 공식 = 홀수 일때는 (*2 - 1), 짝수 일 때는 (*2 + 1)
 * */

public class Problem_11727 {
    public Problem_11727() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int []f;
        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];
        f[1] = 1;
        f[2] = 3;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                f[i] = (f[i - 1] * 2 + 1) % 10007;
            }
            else{
                f[i] = (f[i - 1] * 2 - 1)% 10007;
            }
        }
        bw.write(String.valueOf(f[n]));
        bw.flush();
        bw.close();
    }
}
