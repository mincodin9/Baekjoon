package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs2580 {
    static int[][] board=new int[9][9];

    static boolean DFS(int row, int col) {
        if (col == 9) return DFS(row + 1, 0);
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(j == 8 ? '\n' : ' ');
                }
            }
            System.out.print(sb);
            return true;
        }

        if (board[row][col] != 0) return DFS(row, col + 1);

        for (int v = 1; v <= 9; v++) {
            if (possible(row, col, v)) {
                board[row][col] = v;
                if (DFS(row, col + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean possible(int row, int col, int value){
        for(int i=0; i<9; i++){
            if(board[row][i]==value){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(board[i][col]==value){
                return false;
            }
        }

        int set_row = (row/3)*3;
        int set_col = (col/3)*3;

        for(int i=set_row; i<set_row+3; i++){
            for(int j=set_col; j<set_col+3;j++){
                if(board[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
    }
}
