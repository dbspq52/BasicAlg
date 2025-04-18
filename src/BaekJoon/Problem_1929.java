/**문제
 M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

 입력
 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1929 {
    public Problem_1929() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] arrays = list.stream().mapToInt(Integer::intValue).toArray();

        for(int i = arrays[0]; i <= arrays[1]; i++){
            if(isPrime(i)){
                bw.write(String.valueOf(i));
                bw.newLine();
                bw.flush();
            }
        }
        bw.close();
    }

    private boolean isPrime(int I){
        if(I == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(I); i++){
            if(I % i == 0){
                return false;
            }
        }
        return true;
    }
}
