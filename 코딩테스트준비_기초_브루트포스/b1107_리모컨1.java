package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1107_리모컨1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        if (target == 100) {
            System.out.println(0);
            return;
        }
        int N = Integer.parseInt(br.readLine());

        // 고장난 버튼 리스트 초기화
        List<Integer> list = new ArrayList<>();
        if (N > 0) { // 고장난 버튼이 있을 때만 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 결과값 초기화 (현재 위치 100에서 + 또는 - 버튼만 사용하는 경우)
        int result = Math.abs(target - 100);

        // 가능한 모든 채널을 탐색 (0부터 최대 999,999까지)
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean isValid = true;

            // 숫자가 고장난 버튼을 포함하는지 확인
            for (int j = 0; j < num.length(); j++) {
                int n = num.charAt(j) - '0';
                if (list.contains(n)) {
                    isValid = false;
                    break;
                }
            }

            // 고장난 버튼을 포함하지 않는 유효한 채널일 때만 계산
            if (isValid) {
                // 버튼으로 숫자를 입력한 횟수(num.length()) + 목표 채널까지의 차이
                int clicks = Math.abs(target - i) + num.length();
                result = Math.min(result, clicks);
            }
        }
        System.out.println(result);
    }
}
