/**양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.

 출력
 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem_1037 {
    public Problem_1037() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String []input = new String[2];
        for(int i =0 ;  i < 2; i++){
            input[i] = br.readLine();
        }
        int real = Integer.parseInt(input[0]);
        String []tmp = input[1].split(" ");
        int[] aliquot = new int[tmp.length];

        for(int i =0; i < tmp.length;i++){
            aliquot[i] = Integer.parseInt(tmp[i]);
        }
        int max= 0;
        for(int i = 0 ; i < aliquot.length;i++){
            if(max <= aliquot[i]){
                max = aliquot[i];
            }
        }
        int min = 1000000;
        for(int i = 0 ; i < aliquot.length;i++){
            if(min >= aliquot[i]){
                min = aliquot[i];
            }
        }

        bw.write(String.valueOf(max * min));
        bw.flush();
        bw.close();

    }
}
