package OneThousand;

import java.util.*;

//백준 1002번
public class terret {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        while(T != 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();

            queue.add(findRyu(x1,y1,r1,x2,y2,r2));
            T--;
        }
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    private static int findRyu(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int) (Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

        if(x1 == x2 && y1==y2 && r1==r2){
            return -1;
        }
        else if(distance > Math.pow(r1+r2,2)){
            return 0;
        }
        else if(distance < Math.pow(r2-r1,2) ){
            return 0;
        }
        else if(distance == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        else if(distance == Math.pow(r1 + r2, 2)) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
