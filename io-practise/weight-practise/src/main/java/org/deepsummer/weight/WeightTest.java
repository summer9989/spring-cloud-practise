package org.deepsummer.weight;

import cn.hutool.core.lang.WeightRandom;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class WeightTest {
    @Test
    public void weightMetaTest() {
        Map<String, Integer> weightParams = new ConcurrentHashMap<>(2);
        Map<String, Integer> result = new ConcurrentHashMap<>(2);
        weightParams.put("channel1", 4);
        weightParams.put("channel2", 6);
        WeightMeta<String> weightMeta = RandomUtil.buildWeightMeta(weightParams);


        IntStream.range(0, 10000).forEach(item -> {
            String channel = weightMeta.random();
            result.compute(channel, (k, v) -> v == null ? 1 : v + 1);
        });

        System.out.println(result);
    }

    @Test
    public void hutoolTest() {
        Map<String, Integer> result = new ConcurrentHashMap<>(2);
        WeightRandom.WeightObj<String> channel1 = new WeightRandom.WeightObj<>("channel1", 4);
        WeightRandom.WeightObj<String> channel2 = new WeightRandom.WeightObj<>("channel2", 6);
        WeightRandom<String> weightRandom = cn.hutool.core.util.RandomUtil.weightRandom(new WeightRandom.WeightObj[] {channel1, channel2});

        IntStream.range(0, 10000).forEach(item -> {
            String channel = weightRandom.next();
            result.compute(channel, (k, v) -> v == null ? 1 : v + 1);
        });

        System.out.println(result);
    }

    @Test
    public void binarySearchTest() {
        int[] array = new int[] {1, 3, 4, 6, 8, 9};
        int x1 = Arrays.binarySearch(array, 5);
        int x2 = Arrays.binarySearch(array, 4);
        int x3 = Arrays.binarySearch(array, 0);
        int x4 = Arrays.binarySearch(array, -1);
        int x5 = Arrays.binarySearch(array, 10);
        System.out.println("x1:" + x1 + ", x2:" + x2 + ", x3:" + x3);
        System.out.println("x4:" + x4 + ", x5:" + x5);
    }
}

