import java.util.*;
import java.io.*;
public class b9663_NQueen {
    static int[] cols;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cols = new int[N];
        backtracking(0);
        System.out.println(count);

    }

    private static void backtracking(int row) {
        if(row == cols.length){
            count++;
        }
        else{
            for(int i=0; i<cols.length; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backtracking(row+1);
                }
            }
        }

    }

    private static boolean isPossible(int row) {
        for(int r =0; r<row; r++){
            if(cols[r] == cols[row]){
                return false;
            }
            else{
                if(Math.abs(r-row) == Math.abs(cols[r] - cols[row])){
                    return false;
                }
            }
        }
        return true;
    }
}
