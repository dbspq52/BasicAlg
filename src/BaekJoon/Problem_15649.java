/**자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 입력
 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

 출력
 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_15649 {
    public Problem_15649() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> checkList= new ArrayList<>();
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursionName(checkList, M ,M , bw);
    }

    // 먼저 첫번째 값을 배열에 넣는다.
    //해당 배열에 없는 값이라면 해당 값도 배열에 넣는다.
    //recursion을 한다.
    //그럼 length가 이제 다다르면 return을 하고
    //마지막 한자리를 없앤다.(다른 가능성을 위해)
    private void recursionName(List<Integer> checkList, int N, int M, BufferedWriter bw) throws IOException {
        if(checkList.size() == M){
            System.out.println(checkList);
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!checkList.contains(i)){
                checkList.add(i);
                recursionName(checkList, N, M, bw);
                checkList.removeLast();
            }
        }
    }
}
