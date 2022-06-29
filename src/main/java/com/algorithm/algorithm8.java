package com.algorithm;

// 백준 1002번. 터렛

//문제
//        조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
//
//
//
//        이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
//
//        조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

// 참고: https://st-lab.tistory.com/90


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm8 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(tangent_point(x1, y1, r1, x2, y2, r2)).append('\n');
        }
        System.out.println(sb);
    }

    // 접점 개수 구하는 함수
    public static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	// 중점간 거리 distance의 제곱

        // case 1 : 중점이 같으면서 반지름도 같을 경우
        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
        else if(distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }
        // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
        else if(distance_pow < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        // case 3-1 : 내접할 때
        else if(distance_pow == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        // case 3-2 : 외접할 때
        else if(distance_pow == Math.pow(r1 + r2, 2)) {
            return 1;
        }

        else {
            return 2;
        }
    }
}
