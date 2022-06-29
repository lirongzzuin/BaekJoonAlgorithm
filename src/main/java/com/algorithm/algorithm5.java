package com.algorithm;

// 백준 1929번. 소수 구하기

//M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

//참고: https://st-lab.tistory.com/81, https://prod.velog.io/@newtownboy/JAVA1929%EB%B2%88-%EC%86%8C%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0

// 에라토스테네스의 체

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algorithm5 {
    public static boolean PrimeNumber(int number) {
        // number가 1인경우 소수가 아니기 때문에 false
        if (number < 2) {
            return false;
        }

        // 2부터 i의 제곱이 넘어온 number변수보다 작을 경우 반복문을 수행
        for (int i = 2; i * i <= number; i++) {
            // 나머지가 0일 경우 소수가 아니므로 false
            if (number % i == 0) {
                return false;
            }
        }

        // 그 외의 경우 number는 소수이기 때문에 true
        return true;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자로부터 숫자 두 개를 입력받고 M과 N에 변환을 한 후 대입
        String[] strArray = br.readLine().split(" ");

        int M = Integer.parseInt(strArray[0]);
        int N = Integer.parseInt(strArray[1]);

        // M부터 N까지 반복문 수행
        for (int i = M; i <= N; i++) {
            // true일 경우, 소수이기 때문에 출력
            if (PrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
