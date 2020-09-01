package com.study;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试Gc
 * @date 2020/5/20 7:55
 */

public class TestGC {

    public static final ConcurrentHashMap<Integer, Integer> idMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        /**
         * 测试新生代GC
         * 参数
         * -XX:NewSize=5242880
         * -XX:MaxNewSize=5242880
         * -XX:InitialHeapSize=10485760
         * -XX:MaxHeapSize=10485760
         * -XX:SurvivorRatio=8
         * -XX:PretenureSizeThreshold=10485760
         * -XX:+UseParNewGC
         * -XX:+UseConcMarkSweepGC
         * -XX:+PrintGCDetails
         * -XX:+PrintGCTimeStamps
         * -Xloggc:gc.log
       /*  *//*
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;
        byte[] array2 = new byte[2 * 1024 * 1024];*/

        /**
         * 测试老年代GC
         * 参数
         * -XX:NewSize=10485760
         * -XX:MaxNewSize=10485760
         * -XX:InitialHeapSize=20971520
         * -XX:MaxHeapSize=20971520
         * -XX:SurvivorRatio=8
         * -XX:MaxTenuringThreshold=15
         * -XX:PretenureSizeThreshold=10485760
         * -XX:+UseParNewGC
         * -XX:+UseConcMarkSweepGC
         * -XX:+PrintGCDetails
         * -XX:+PrintGCTimeStamps
         * -Xloggc:gc.log
         */
/**
 * 参数：
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *//*
        byte[] array1 = new byte[4 * 1024 * 1024];
        array1 = null;
        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        byte[] array5 = new byte[128 * 1024];

        byte[] array6 = new byte[2 * 1024 * 1024];
*/
    }
}
