package com.urise.webapp;

import java.util.*;
import java.util.stream.*;

public class MainStream {
    public static void main(String[] args) {
        int[] values = {1,2,3,3,2,3};
        System.out.println(minValue(values));
        List<Integer> integers = Arrays.stream(values)
                                    .boxed()
                                    .collect(Collectors.toList());
        System.out.println(oddOrEven(integers));
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values)
                .filter(x -> x >= 1)
                .filter(x -> x <= 9)
                .distinct()
                .sorted()
                .reduce(0, (acc, x) -> acc * 10 + x);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        final Map<Boolean, List<Integer>> oddsAndEvens = integers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        return oddsAndEvens.get(oddsAndEvens.get(false).size() % 2 != 0);
    }
}
