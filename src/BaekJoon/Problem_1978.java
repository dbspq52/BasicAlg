/*문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
* */
package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Problem_1978 {
    public Problem_1978() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();

        //소수라는 것이 뭐야??? 1과 자기 자신 밖에 없는 것.
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(isPrime(nums[i])){
                sum++;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
