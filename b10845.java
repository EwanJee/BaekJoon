import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10845 {

    static int[] array = new int[10000];
    static int first = 0;
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void push(int i){
        array[last] = i;
        last++;
    }
    public static int pop(){
        if(last - first == 0){
            return -1;
        }
        else {
            int popped = array[first];
            first++;
            return popped;
        }
    }
    public static int size(){
        return last-first;
    }
    public static int empty(){
        if(last == first) return 1;
        return 0;
    }
    public static int front(){
        if(last - first == 0){
            return -1;
        }
        return array[first];
    }
    public static int back(){
        if(last - first == 0){
            return -1;
        }
        return array[last-1];
    }
}
