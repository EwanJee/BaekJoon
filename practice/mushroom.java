package practice;

import java.util.*;

public class mushroom {
    static int x;
    static int y;
    static Stack<Integer>[] arr;
    static Stack<Integer> bag = new Stack<>();
    static int count = 0;

    public static void main(String[] args){
        int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[] {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

    }
    public static int solution(int[][] board, int[] moves) {
        x = board.length; // row
        y = board[0].length; // column

        arr = new Stack[x];

        for(int i=0; i<x; i++){
            arr[i] = new Stack<>();
        }
        int row = 0;
        for(int i=0; i< y; i++){
            for(int j=0; j<x; j++){
                arr[row].add(board[j][i]);
            }
            row++;
        }


        for(int i : moves){
            if(arr[i-1].isEmpty()) continue;
            if(bag.isEmpty()){
                bag.add(arr[i-1].pop());
                continue;
            }
            int top = bag.peek();
            bag.add(arr[i-1].pop());
            if(top == bag.peek()){
                count += 2;
                bag.pop();
                bag.pop();
            }
        }
        return count;
    }
}