import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1406 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.substring(i,i+1));
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case "P":
                    String input = st.nextToken();
                    leftStack.push(input);
            }
        }
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
    }
}
