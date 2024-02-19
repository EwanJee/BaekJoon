import java.io.*;
import java.util.*;
public class b17413 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        boolean flag = true;
        while(index != str.length()){
            char c = str.charAt(index);
            if(c == '<'){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
                sb.append(c);
                flag = false;
            }
            else if(c == '>' && !flag){
                sb.append(c);
                flag = true;
            }
            else if(c == ' '){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
                sb.append(c);
            }
            else{
                if(!flag){
                    sb.append(c);
                }
                else{
                    stack.push(c);
                }
            }
            index++;
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        System.out.println(sb);
    }
}
