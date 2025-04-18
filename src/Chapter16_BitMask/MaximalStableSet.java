package Chapter16_BitMask;

import java.io.PrintStream;

public class MaximalStableSet {
    private int N = 4;
    private int[] arr = {2, 1, 8, 4};//인덱스 값의 폭탄 값이라 하자.
    private int count = 0;
    public MaximalStableSet(){
    }

    public Boolean isSafety(int set){
        for(int i = 0; i < N; i++){
            if(((set & (1 << i)) != 0) && (arr[i] & set) != 0){
                System.out.println("False");
                return false;
            }
        }
        System.out.println("True");
        return true;
    }

    public void StableSet(){
        for(int set = 1; set < (1 << N); set++){
            System.out.printf("%d", set);
            if(isSafety(set)){
                System.out.printf("%d",set);
                boolean Boom = true;
                for(int j = 0; j < N; j++){
                    if (((set & (1 << j)) == 0) && ((arr[j] & set) == 0)) {
                        Boom = false;
                        break;
                    }
                }
                if(Boom){
                    count++;
                }
            }
        }
        System.out.printf("Result : %d", count);
    }
}
