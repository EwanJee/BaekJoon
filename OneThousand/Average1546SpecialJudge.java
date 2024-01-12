package OneThousand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average1546SpecialJudge {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            list.add(in.nextInt());
        }
        calculateAverage(count, list);
    }
    public static void calculateAverage(int count, List<Integer> list){
        double max = list.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0);
        double sum = 0;
        for (Integer integer : list) {
            sum += integer / max * 100;
        }
        double average = sum / list.size();
        System.out.println(average);
    }
}
