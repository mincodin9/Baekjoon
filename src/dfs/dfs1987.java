package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs1987 {
    static int R, C, answer=0;
    static char[][] board;
    static boolean[] checked=new boolean[26];
    static int[] dx={0, 1, 0, -1};
    static int[] dy={-1, 0, 1, 0};

    static void DFS(int L, int x, int y) {
        answer = Math.max(answer, L);

        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

            int idx=board[nx][ny]-'A';
            if(!checked[idx]){
                checked[idx]=true;
                DFS(L+1, nx, ny);
                checked[idx]=false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        board=new char[R][C];
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j]=line.charAt(j);
            }
        }
        int idx=board[0][0]-'A';
        checked[idx]=true;
        DFS(1, 0, 0);
        System.out.println(answer);
    }
}
