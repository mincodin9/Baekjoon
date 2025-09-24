package lv1;

import java.util.Scanner;

public class lv1_secretMap {
    String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            int x = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder(n);
            for(int b=n-1; b>=0; b--){
                if((x & (1<<b)) != 0) sb.append("#");
                else sb.append(" ");
            }
            answer[i]=sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        lv1_secretMap T = new lv1_secretMap();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i<n; i++) arr1[i]=sc.nextInt();
        for(int i=0; i<n; i++) arr2[i]=sc.nextInt();

        String[] answer=T.solution(n, arr1, arr2);
        for(String s: answer) System.out.println(s);

    }
}
