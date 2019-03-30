package com.iamlook.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-06 10:51
 **/
public class LinkedListTest {

    public  static  List<String> arraryList = new ArrayList<>(10);
    public  static  List<String> linkedList = new LinkedList<>();
    public static void main(String[] args) {

        while (true){
            arraryList.add("我是ArraryList【" + 1 + "】");
        }

        /*for (int i = 0; i < 10000; i++) {
            arraryList.add("我是ArraryList【" + i + "】");
            linkedList.add("我是ArraryList【" + i + "】");
        }

        System.out.println("ArrayList访问消耗的时间：" + getTime(arraryList));
        System.out.println("LinkedList访问消耗的时间：" + getTime(linkedList));*/


        /*arraryList.add("hello");
        arraryList.add("word");
        arraryList.add("java");

        ListIterator it = arraryList.listIterator();
        while(it.hasNext()){
            String s = (String) it.next();
            System.out.println(s);
            if("word".equals(s)){
                arraryList.add("como ono");
            }
        }



        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("asdasd", 234234);
        concurrentHashMap.get("asdsd");
        linkedList.add(7, "asd");
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("1",1) ;
        map.put("2",2) ;
        map.put("3",3) ;
        map.put("4",4) ;
        map.put("5",5) ;
        System.out.println(map.toString());
*/







    }

    private static long getTime(List<String> list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            list.add(334, "在索引为10的位置插入"); // 在索引为10的位置插入i
        }
        return System.currentTimeMillis() - time;
    }
}
