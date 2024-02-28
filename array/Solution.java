package array;

import java.util.*;
public class Solution {
    public static List<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        s = s.substring(1,s.length()-1);

        String[] arr = s.split("},*");
        String[] a = new String[arr.length];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                if(arr[i].charAt(j) == ','){
                    count++;
                }
            }
            a[count] = arr[i].substring(1);
            count = 0;
        }
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<a.length; i++){
            String[] temp = a[i].split(",");
            for(String t : temp){
                set.add(Integer.parseInt(t));
            }
        }
        List<Integer> list = set.stream().toList();
        for(int z : list){
            System.out.println(z);
        }
        return list;
    }
    public static void main(String[] args){
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}