package com.iamlook.classload;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-26 10:33
 **/
public class ClassLoadTest {

    public static void main(String[] args) {

        /*
        System.out.println(SubClass.value);
        为什么没有输出SubClass init。ok~解释一下：对于静态字段，
        只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，
        只会触发父类的初始化而不会触发子类的初始化。
         */
        System.out.println(SubClass.value);

        /*
        类加载过程


        类从被加载到虚拟机内存中开始，到卸载出内存为止，它的整个生命周期包括：
        加载（Loading）、验证（Verification）、准备(Preparation)、解析(Resolution)、
        初始化(Initialization)、使用(Using)和卸载(Unloading)7个阶段。其中验证、准备、解析3个部分统称为连接（Linking）


        加载、验证、准备、初始化和卸载这5个阶段
         */




        /*

        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    try {
                        if (parent != null) {
                            c = parent.loadClass(name, false);
                        } else {
                            c = findBootstrapClassOrNull(name);
                        }
                    } catch (ClassNotFoundException e) {
                        // ClassNotFoundException thrown if class not found
                        // from the non-null parent class loader
                    }

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        c = findClass(name);

                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }*/
    }
}
