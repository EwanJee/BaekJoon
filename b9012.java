import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c == '('){
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()){
                        stack.push(c);
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}