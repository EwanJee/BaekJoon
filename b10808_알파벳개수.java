import java.io.*;
public class b10808_알파벳개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int['z'-'a'+1];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-97] += 1;
        }
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
