import java.io.*;
import java.util.StringTokenizer;

public class b10828 {
    //스택이용문제
    public static int[] stack;
    public static int index = 0;

    public static void push(int input){
        stack[index] = input;
        ++index;
    }
    public static int top(){
        if(index == 0){
            return -1;
        }
        return stack[index-1];
    }
    public static int size(){
        return index;
    }
    public static int empty(){
        if(index==0){
            return 1;
        }
        return 0;
    }
    public static int pop(){
        if(index == 0){
            return -1;
        }
        int popped = stack[index-1];
        stack[index-1] = 0;
        index--;
        return popped;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];
        StringBuilder sb = new StringBuilder();
        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command1 = st.nextToken();
            if(command1.equals("push")){
                int command2 = Integer.parseInt(st.nextToken());
                push(command2);
            }
            else if(command1.equals("pop")){
                sb.append(pop()).append("\n");
            }
            else if(command1.equals("top")){
                sb.append(top()).append("\n");
            }
            else if(command1.equals("empty")){
                sb.append(empty()).append("\n");
            }
            else if (command1.equals("size")) {
                sb.append(size()).append("\n");
            }
            N--;
        }
        System.out.println(sb);
    }
}
