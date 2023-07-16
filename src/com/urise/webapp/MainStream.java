package com.urise.webapp;

import java.util.Arrays;

public class MainStream {
    public static void main(String[] args) {

    }

    private int minValue(int[] values) {
        return Arrays.stream(values)
                .filter(x -> x >= 1)
                .filter(x -> x <= 9)
                .distinct()
                .sorted()
                .reduce(0, (acc, x) -> acc * 10 + x);
    }

//    private List<Integer> oddOrEven(List<Integer> integers) {
//        return integers.stream()
//                .collect(Collectors.)
//    }
}
