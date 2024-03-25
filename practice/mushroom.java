package practice;

import java.util.Arrays;
import java.util.Collections;

public class mushroom {

    public static void main(String[] args){
        AnnotationProcesor.process(mushroom.class);
    }
    @Annotation(value = 1)
    private static Object hello(){
        return null;
    }
}