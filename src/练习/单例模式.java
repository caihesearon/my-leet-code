package 练习;

/**
 * @author hecai
 * @date 2020/9/10
 */
public class 单例模式 {
    /**
     * 饿汉模式
     */
//    public static 单例模式 singleMode = new 单例模式();
//    //private构造方法保证外部无法进行实例化
//    private 单例模式(){}

    /**
     * 懒汉模式
     */
//    private static 单例模式 singleMode;
//    private 单例模式(){}
//    public static synchronized 单例模式 getSingleMode(){
//        if(singleMode == null){
//            singleMode = new 单例模式();
//        }
//        return singleMode;
//    }

    /**
     * 双重检测
     */
    /**
     * 这里需要加volatile关键字保证有序，去掉创建对象时的重排序
     * 因为singleMode = new 单例模式()会分为以下三步进行
     * 1、分配对象的内存空间
     * 2、初始化对象
     * 3、将对象的内存地址分配给singleMode对象引用
     * 在这里第二步和第三步会发生重排序的，这在单线程的模式下是没有问题的
     * 但是在多线程的情况下有可能A线程在执行到new 单例模式()这里的时候还没有初始化对象就
     * 将对象的内存地址分配的对象引用了，这时B线程有可能会执行到if(singleMode == null)
     * 则会出现B线程获取到的是一个没有初始化的对象
     * 所以需要在变量上加一个volatile关键字来去除指令的重排序
     * 在不影响程序运行结果的情况下是允许指令的重排的
     */
    private static volatile 单例模式 singleMode;
    private 单例模式() {
    }
    public static 单例模式 getSingle() {
        if (singleMode == null) {//single check
            synchronized (单例模式.class) {//对象加锁
                if (singleMode == null) {// double check
                    singleMode = new 单例模式();
                }
            }
        }
        return singleMode;
    }


}
