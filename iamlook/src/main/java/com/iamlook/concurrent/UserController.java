package com.iamlook.concurrent;

import java.util.HashMap;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-02-22 11:36
 **/
public class UserController {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {



        /*User user = new User();
        User user1 = new User();
       *//* *//**//*User user1 = User.class.newInstance();*//**//*
        User user2 = (User) Class.forName("com.iamlook.concurrent.User").newInstance();
        System.out.println(user2.i);*//*




        System.out.println(user.equals(user1));
        System.out.println(user == user1);
        System.out.println();
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());


        HashMap map = new HashMap();
        map.put(user, "11111");
        map.put(user1, "222222");


        System.out.println(map.get(user));
        System.out.println(map.get(user1));*/

    }



    /***

     public Class<?> loadClass(String name) throws ClassNotFoundException {

     return loadClass(name, false);

     }

      protected synchronized Class<?> loadClass(String name, boolean resolve)

     throws ClassNotFoundException

         {

     // 首先判断该类型是否已经被加载

     Class c = findLoadedClass(name);

     if (c == null) {

     //没有被加载，就委托给父类加载器或者委派给启动类加载器加载

         try {

     if (parent != null) {

     // 如果存在父类加载器，就委派给父类加载器加载

      

     c = parent.loadClass(name, false);

     } else {

     // 如果不存在父类加载器，就检查是否是由启动类加载器加载的类

         c = findBootstrapClassOrNull(name);

     }

         } catch (ClassNotFoundException e) {

                     

             }

           if (c == null) {

             // 如果父类加载器和启动类加载器都不能完成加载任务，调用自身的加载工程

             c = findClass(name);

         }

     }

     if (resolve) {

         resolveClass(c);

     }

     return c;

         }

    */
}
