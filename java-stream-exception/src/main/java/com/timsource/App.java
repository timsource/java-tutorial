package com.timsource;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        List<String> integers = Arrays.asList("10", "20", "30");
        System.out.println(app.sumLegacy(integers));
        System.out.println(app.sumAllStreamLegacy(integers));
        System.out.println(app.sumAllStream(integers));
    }

    public int sumAllStream(List<String> integers) {
        return integers.stream()
                .map(Integer::parseInt)
                .map(ExceptionWrapperFunction.unchecked(this::takeActionWithException))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int sumAllStreamLegacy(List<String> integers) {
        return integers.stream()
                .map(Integer::parseInt)
                .map(o -> {
                    try {
                        return takeActionWithException(o);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int sumLegacy(List<String> strings) throws InterruptedException {
        int total = 0;
        for (String s : strings) {
            int value = Integer.parseInt(s);
            total += takeActionWithException(value);
        }
        return total;
    }

    //mocking function with exception
    private int takeActionWithException(int input) throws InterruptedException {
        Thread.sleep(input);
        return ++input;
    }

}
