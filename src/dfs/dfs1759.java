package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dfs1759 {
    static int l, C;
    static char[] arr, code;

    static void DFS(int L, int x){
        if(L==l){
            isValid(code);
        }else{
            for(int i=x; i<C; i++){
                code[L]=arr[i];
                DFS(L+1, i+1);
            }
        }
    }

    static void isValid(char[] code){
        int consonant=0;
        int vowel=0;

        for(char x: code){
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') vowel++;
            else consonant++;
        }
        if(vowel>=1 && consonant>=2) {
            System.out.println(new String(code));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new char[C];
        code=new char[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            arr[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        DFS(0, 0);
    }
}
