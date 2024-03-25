package practice;

import java.util.Arrays;
import java.util.Collections;

public class mushroom {

    public static void main(String[] args){
//        AnnotationProcesor.process(mushroom.class);
        String[] arr = new String[]{"s","t","a","v"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Annotation(value = 1)
    private static Object hello(){
        return null;
    }

}