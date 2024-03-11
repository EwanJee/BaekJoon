package 코딩테스트준비_기초_브루트포스;

public class test {
    static int a= 2;
    public static void main(String[] args){
        int[] list = new int[] {1,2};
        change(a,list);
//        for(int each : list){
//            System.out.println(each);
//        }
        System.out.println(recur(a));
    }
    private static void change(int a, int[] list){
        a = 3;
        list[0] = 9;
    }
    private static int recur(int a){
        if(a == 0) {
            System.out.println("TT");
            return 0;
        }
        recur(a-1);
        System.out.println("OO");
        return -1;
    }
}
