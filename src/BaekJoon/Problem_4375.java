package BaekJoon;

import java.io.*;

public class Problem_4375 {
    public Problem_4375() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            bw.write(foundOne(n));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private String foundOne(int n) {
        int mod = 1;
        int length = 1;

        while (mod % n != 0) {
            System.out.println(mod);
            mod = (mod * 10 + 1) % n;
            length++;
        }
        return String.valueOf(length);
    }
}
