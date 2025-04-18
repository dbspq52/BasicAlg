package EasyPeasy;

import java.io.*;
import java.util.StringTokenizer;

public class Q_10430 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    public static void play() throws IOException {
        String ABC= br.readLine();
        StringTokenizer st = new StringTokenizer(ABC);
        int[] arr = new int[3];
        int i = 0;

        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        bw.write((arr[0] + arr[1]) % arr[2]);
        bw.write(((arr[0] % arr[2]) + (arr[1] % arr[2])) % arr[2]);
        bw.write((arr[0] * arr[1]) % arr[2]);
        bw.write(((arr[0] % arr[2]) *(arr[1] % arr[2])) % arr[2]);
        bw.flush();
        bw.close();
    }
}
