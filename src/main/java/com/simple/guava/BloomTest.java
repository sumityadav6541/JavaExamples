/*
 * Copyright by sumit yadav
 */

package com.simple.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sumit Yadav on 21/07/19.
 */
public class BloomTest {

  public static void main(String[] args) {
    test1();
    test0();


  }

  private static void test0() {
    //Default false positive acceptance is 3% or 0.03
    BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000);

    bloomFilter.put(1);
    bloomFilter.put(2);
    bloomFilter.put(3);
    bloomFilter.put(4);

    System.out.println(bloomFilter.mightContain(1));
    System.out.println(bloomFilter.mightContain(2));
    System.out.println(bloomFilter.mightContain(3));
    System.out.println(bloomFilter.mightContain(4));
    System.out.println(bloomFilter.mightContain(5));
  }

  private static void test1() {
    BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000, 0.01);

    IntStream.range(1, 500)
        .map(x -> {
          System.out.println("adding to the bloom => " + x);
          return x;
        })
        .forEach(bloomFilter::put);
    IntStream
        .range(500, 100_000_0)
        .mapToObj(x -> x)
        .collect(
            Collectors.partitioningBy(bloomFilter::mightContain)
        )
        .forEach((k, v) -> System.out.println("Key :" + k + ", Value : " + v));
  }

}
