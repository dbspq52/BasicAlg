package BaekJoon;

import java.io.*;
import java.util.Arrays;

/**정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

 명령은 총 여덟 가지이다.

 push_front X: 정수 X를 덱의 앞에 넣는다.
 push_back X: 정수 X를 덱의 뒤에 넣는다.
 pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 size: 덱에 들어있는 정수의 개수를 출력한다.
 empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 입력
 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * */
public class Problem_10866 {
    public Problem_10866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mainContainer(N, br);
    }

    private void mainContainer(int n, BufferedReader br) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String order;
        for(int i= 0 ; i < n; i++){
            order = br.readLine();
            functionContainer(order, bw);
        }
        bw.close();
    }

     private void functionContainer(String order, BufferedWriter bw) throws IOException {
        String[] orders = order.split(" ");
        int x = 0;
        int result;
        if(orders.length >= 2){
            x = Integer.parseInt(orders[1]);
        }
        switch(orders[0]){
            case "push_front":
                Deque.inputFront(x);
                break;
            case "push_back":
                Deque.inputBack(x);
                break;
            case "pop_front":
                result = Deque.popFront();
                justPrint(result,bw);
                break;
            case "pop_back":
                result = Deque.popBack();
                justPrint(result, bw);
                break;
            case "size":
                result = Deque.size();
                justPrint(result, bw);
                break;
            case "empty":
                result = Deque.empty();
                justPrint(result, bw);
                break;
            case "front":
                result = Deque.front();
                justPrint(result, bw);
                break;
            case "back":
                result = Deque.back();
                justPrint(result, bw);
                break;

        }
    }
    private void justPrint(int result, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
    }
}


class Deque{
    static int []arr = new int[10000];
    static int head = 0;
    static int rear = 0;
    static public void inputFront(int x){
        if (head != rear) {
            for (int i = rear - 1; i >= head; i--) {
                arr[i + 1] = arr[i];
            }
        }
        arr[head] = x;
        rear = (rear +  1) % 10000;
    }
    static public void inputBack(int x){
        arr[rear] = x;
        rear = (rear + 1) % 10000;
    }
    static public int popFront(){
        if(head == rear){
            return -1;
        }
        int tmp  = arr[head];
        arr[head] = 0;
        head += 1;
        return tmp;
    }
    static public int popBack(){
        if(head == rear){
            return -1;
        }
        int tmp  = arr[rear - 1];
        arr[rear - 1] = 0;
        rear = rear - 1;
        return tmp;
    }
    static public int size(){
        return rear - head;
    }
    static public int empty(){
        if(head == rear){
            return 1;
        }
        else{
            return 0;
        }
    }
    static public int front(){
        if(head == rear){
            return -1;
        }
        return arr[head];
    }
    static public int back(){
        if(head == rear){
            return -1;
        }
        return arr[rear-1];
    }
}