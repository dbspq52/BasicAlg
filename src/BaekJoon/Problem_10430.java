package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_10430 {
    private  int a;
    private  int b;
    private  int c;

    public Problem_10430() throws IOException {
        result(init());
    }

    private int[] init() throws IOException {
        int []arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("문자열 입력: ");
        StringTokenizer input = new StringTokenizer(br.readLine()); // 한 줄씩 읽기

        int tokenCount = input.countTokens();  // 먼저 고정된 값 저장
        arr = new int[tokenCount];
        for(int i = 0; i < tokenCount; i++){
            arr[i] = Integer.parseInt(input.nextToken());}
        return arr;
    }

    private void result(int[] arr) throws IOException {
        //A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] resultArr = makeSomething(arr);
        for(int i = 0 ; i < 4; i++){
            bw.write(String.valueOf(resultArr[i])); // 출력 버퍼에 저장
            bw.newLine(); // 줄바꿈 (bw.write("\n")과 동일)
        }

        bw.flush(); // 버퍼 비우기 (출력 실행)
        bw.close(); // 스트림 닫기
    }
    private int[] makeSomething(int[] arr){
        int [] returnArr = new int[4];
        int A = 0;
        int B = 1;
        int C = 2;
        returnArr[0] = (arr[A] + arr[B]) % arr[C];
        returnArr[1] = (arr[A] % arr[C] + arr[B]%arr[C]) %arr[C];
        returnArr[2] = (arr[B] * arr[A]) %arr[C];
        returnArr[3] = ((arr[A] % arr[C]) * (arr[B] % arr[C]))% arr[C];

        return returnArr;
    }
}
