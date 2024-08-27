package 코딩테스트준비_기초_수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1037_약수 {
    /**
     * 2초
     * N <= 1,000,000 = 10^6
     *
     * O(N) 또는 O(NlogN)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int min = Collections.min(list);
        int max = Collections.max(list);
        System.out.println(min * max);
    }
}
