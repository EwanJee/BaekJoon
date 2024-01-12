import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9093 {
    //단어 뒤집기
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T --> 0){
            String input = br.readLine();
            convert(input, sb);
        }
        br.close();
        System.out.println(sb);
    }
    public static void convert(String s, StringBuilder sb){
        String[] temp = s.split(" ");
        for(String word : temp){
            StringBuilder sb2 = new StringBuilder(word);
            sb.append(sb2.reverse().toString()).append(" ");
        }
        sb.append("\n");
    }
}
