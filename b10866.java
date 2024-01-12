import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push_back":
                    int input2 = Integer.parseInt(st.nextToken());
                    q.addLast(input2);
                    break;
                case "push_front":
                    int input = Integer.parseInt(st.nextToken());
                    q.addFirst(input);
                    break;
                case "front":
                    if(q.size() == 0 ) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(q.peekFirst()).append("\n");
                    break;
                case "back":
                    if(q.size() == 0){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(q.peekLast()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "pop_front":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(q.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(q.pollLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
