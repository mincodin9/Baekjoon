import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        int answer = 0;

        for(int i=0; i<input; i++){
            answer = answer+(i+1);
        }

        System.out.println(answer);
    }
}
