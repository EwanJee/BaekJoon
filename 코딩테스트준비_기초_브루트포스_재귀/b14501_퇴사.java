package 코딩테스트준비_기초_브루트포스_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14501_퇴사 {
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] time = new int[N];
        int[] price = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            price[i] = p;
        }
        dfs(N,time,price,0,0);
        System.out.println(max);
    }
    private static void dfs(int N,int[] time, int[] price, int index, int sum){
        if(index>=N){
            max = Math.max(max,sum);
            return;
        }
        if(index+time[index]<=N) dfs(N,time,price,index+time[index],sum+price[index]);
        dfs(N,time,price,index+1,sum);
    }
}
