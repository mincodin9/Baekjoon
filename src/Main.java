import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String str = bf.readLine();
        String[] strArray = str.split(" ");

        int[] result = new int[strArray.length];
        for (int i =0; i< strArray.length; i++){
            result[i] = Integer.parseInt(strArray[i]);
        }

        if(result[0] == result[1] && result[1] == result[2] && result[0] == result[2]){
            answer = 10000 + result[0]*1000;
        }
        else if(result[0] != result[1] && result[1] != result[2] && result[0] != result[2]){
            int biggest = 0;
            if(result[0]>result[1]){
                biggest = result[0];
            }
            else{
                biggest = result[1];
            }
            if(result[2]>biggest){
                biggest = result[2];
            }

            answer = biggest*100;
        }
        else{
            if(result[0] == result[1]){
                answer = 1000 + result[0]*100;
            }
            else if(result[1]==result[2]){
                answer = 1000 + result[1]*100;
            }
            else{
                answer = 1000 + result[0]*100;
            }
        }

        System.out.println(answer);
    }
}