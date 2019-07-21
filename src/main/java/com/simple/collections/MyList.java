/*
 * Copyright by sumit yadav
 */

package com.simple.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sumit Yadav on 21/07/19.
 */
public class MyList {

  public static void main(String[] args) {
    /*
    test1();
    test2();
    test3();
    test4();
    */

    //test5();



    test6();




  }

  //create a space efficient list of same n items
  private static void test6() {
    List<Integer> ints = Collections.nCopies(5, 5);
    System.out.println(ints);
  }

  private static void test5() {
    List<Integer> ints = Collections.singletonList(1);
    System.out.println(ints);
    ints.add(2);
    System.out.println(ints);
  }

  private static void test4() {
    List uncertainList = Arrays.asList(1,2,3,4);

    Collections.checkedList(
        new ArrayList<String>(uncertainList.size()), String.class)
        .addAll(uncertainList);
  }

  private static void test3() {
    List<Integer> ints = Collections.emptyList();
    System.out.println(ints);
  }

  private static void test2() {
    List<Integer> ints = new LinkedList<>();
    ints.add(1);
    ints.add(2);
    ints.add(3);
    ints.add(5);
    System.out.println(ints);
  }

  private static void test1() {
    List<Integer> ints = new ArrayList<>();
    ints.add(1);
    ints.add(2);
    ints.add(3);
    System.out.println(ints);
  }

}
