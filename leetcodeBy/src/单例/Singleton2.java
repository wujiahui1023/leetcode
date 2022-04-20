package 单例;

/**
 * @program: leetcodeBy
 * @description: 通过内部类实现多线程环境中的单例模式
 * @author: wuJh
 * @create: 2022-04-17 15:11
 **/
public class Singleton2 {

    private Singleton2(){

    }
    private static class SingletonContainer{
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return SingletonContainer.instance;
    }


}
