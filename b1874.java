import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while(T --> 0){
            int value = Integer.parseInt(br.readLine());
            if(current < value){
                for(int i= current+1; i<=value; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                current = value;
            }
            else if(stack.peek() != value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
