package tools.simple;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/14 15:22
 */
public class JVM之对象创建过程 {

    //成员变量
    private int i = 1;
    private int j = 1;

    public  JVM之对象创建过程(int c){
        System.out.println(i);
        System.out.println(j);
        this.i = c;
        System.out.println(i);
    }
    //代码块
    {
        j = j+1;
    }
    //静态代码块
    static{
        int a = 5;
        System.out.println(a);
    }
    public static void main(String[] args) {
        new JVM之对象创建过程(3);
    }


}
