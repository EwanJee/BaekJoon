package practice;

import java.lang.reflect.Method;

public class AnnotationProcesor {
    public static void process(Object obj){
        Method[] methods = obj.getClass().getDeclaredMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(Annotation.class)){
                Annotation annotation = method.getAnnotation(Annotation.class);
                if(annotation.value() == 1){
                    System.out.println("1!");
                }
            }
        }
    }
}
