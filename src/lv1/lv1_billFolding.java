package lv1;

import java.util.Arrays;
import java.util.Scanner;

public class lv1_billFolding {
    int Solution(int[] wallet, int[] bill) {
        int answer=0;

        Arrays.sort(bill);
        Arrays.sort(wallet);
        while(wallet[0]<bill[0] || wallet[1]<bill[1]){
            bill[1]=bill[1]/2;
            Arrays.sort(bill);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        lv1_billFolding T = new lv1_billFolding();
        Scanner sc = new Scanner(System.in);
        int[] wallet = new int[2];
        int[] bill = new int[2];
        for(int i=0; i<2; i++) wallet[i]=sc.nextInt();
        for(int i=0; i<2; i++) bill[i]=sc.nextInt();
        System.out.println(T.Solution(wallet, bill));
    }
}
