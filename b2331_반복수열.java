import java.util.*;
import java.io.*;

public class b2331_반복수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int current = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        list.add(current);
        while(true){
            current = calculate(current,p);
            if(!list.contains(current)) list.add(current);
            else{
                int i = list.indexOf(current);
                System.out.println(i);
                break;
            }
        }
    }

    private static int calculate(int current, int p) {
        String str = current + "";
        int answer= 0;
        for(int i=0; i<str.length(); i++){
            int temp = str.charAt(i) - '0';
            answer += (int) Math.pow(temp,p);
        }
        return answer;
    }
}
