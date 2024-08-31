package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2309_일곱난쟁이 {
    /**
     * 시간 제한 2초
     * 메모리 제한 128MB
     */
    /**
     * 9명을 리스트에 담고 합을 구한다.
     * 100을 뺀다
     * for loop 2번 사용해 두 인덱스의 합이 같은 것을 고른다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        boolean[] visited = new boolean[9];
        int[] reals = new int[7];
        dfs(arr,0, 0, visited, reals);
        Arrays.sort(reals);
        for(int each : reals){
            System.out.println(each);
        }
    }
    private static void dfs(int[] arr, int depth, int real, boolean[] visited, int[] reals){
        if(depth == 7 && real == 100){
            int index=0;
            for(int i=0 ; i<visited.length; i++){
                if(visited[i]){
                    reals[index++] = arr[i];
                }
            }
        }
        else{
            for(int i=0; i<arr.length; i++){
                if(!visited[i] && depth+1 <= 7 && real + arr[i]<=100){
                    visited[i] = true;
                    dfs(arr,depth+1, real + arr[i], visited, reals);
                    visited[i] = false;
                }
            }
        }
    }
}
