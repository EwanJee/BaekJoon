import java.util.Scanner;

public class b10430 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A, B, C;
        A = in.nextInt();
        B = in.nextInt();
        C = in.nextInt();

        int input1 = (A+B)%C;
        int input2 = ( (A%C) + (B%C) )%C;
        int input3 = (A*B)%C;
        int input4 = ( (A%C) * (B%C) )%C;

        System.out.println(input1);
        System.out.println(input2);
        System.out.println(input3);
        System.out.println(input4);
    }
}
