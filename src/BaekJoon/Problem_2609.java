/**문제
 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

 입력
 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

 출력
 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem_2609 {
    List<Integer> arr = new ArrayList<>();
    public Problem_2609() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        //최대 공약수란???
        printMax(Integer.parseInt(a),Integer.parseInt(b), 2);
    }
    //최대 공약수는 최대로 나누어라 서로를
    //2부터 시작 작은 수까지
    //나누어지는 것이 있다면 나눈다. 해당 칼로 쓴 정수는 저장
    //나머지를
    private void printMax(int a, int b, int knife){
        if((knife == Math.min(a, b) && (Math.max(a,b) % knife) !=0) || Math.min(a,b) == 1){
            int mul = 1;
            for (Integer integer : arr) {
                mul *= integer;
            }
            System.out.println(mul);
            System.out.println(mul * a * b);
            return;
        }


        if(a % knife == 0 && b % knife == 0){
            arr.add(knife);
            printMax(a / knife, b / knife, 2);
        }
        else{
            printMax(a, b, knife + 1);
        }
    }
}
