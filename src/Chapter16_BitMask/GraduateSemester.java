package Chapter16_BitMask;

import javax.security.auth.Subject;
import java.util.Scanner;
public class GraduateSemester {
    private int numSubject;
    private int numMustDo;
    private int numSemester;
    private int numCanApply;
    private int testCase;
    Scanner scanner = new Scanner(System.in);
    private int[] SubjectMaskArray =new int[12];


    public GraduateSemester(){}

    public void WillDOThis(int SubjectMask){
        for(int i = 0; i < numSubject; i++){
            if((SubjectMaskArray[i] & SubjectMask) != 0) {
                SubjectMaskArray[i] -= SubjectMask;
            }
        }
        numMustDo--;
    }
    public boolean Checking(int SubjectMask){
        return Integer.bitCount(SubjectMask) == 1;
    }

    public void Input(){
        this.testCase = scanner.nextInt();
        this.numSubject = scanner.nextInt();
        this.numMustDo = scanner.nextInt();
        this.numSemester = scanner.nextInt();
        this.numCanApply = scanner.nextInt();

        for(int i = 0; i < testCase; i++){
            for(int sub = 0; sub < numSubject; sub++){
                int numPre = scanner.nextInt();
                int subBinary = (1 << sub);
                for(int j = 0; j < numPre; j++){
                    int prePadding = scanner.nextInt();
                    int preBinary = (1 << prePadding);
                    subBinary |= preBinary;
                }
                SubjectMaskArray[sub] = subBinary;
            }

            for(int k = 0; k < numSemester; k++){
                int C = scanner.nextInt();
                int[] subIndex = new int[numSubject];
                for(int c = 0; c < C; c++){
                    int sub = scanner.nextInt();
                    if(Checking(SubjectMaskArray[sub])){
                        subIndex[c] = sub;
                    }
                    else{
                        subIndex[c] = -1;
                    }
                }
                for(int c = 0; c < C; c++){
                    if(subIndex[c] != -1){
                        WillDOThis(SubjectMaskArray[subIndex[c]]);
                    }
                }

                if(numMustDo == 0){
                    System.out.println("Minimum is: " + (k + 1));
                    break;
                }
            }

        }
    }
}
