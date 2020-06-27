package cn.itcast.day15.demo03;
/*
* Lambda表达式的标准格式
*       由三部分组成：
*           1、一些参数
*           2、一个箭头
*           3、一段代码
*       格式：
*           (参数列表) -> {一些重写方法的代码};
*       解释说明格式：
*           ()：接口中抽象方法的参数列表，没有参数，就空着；有参数就写出参数，多个参数使用逗号分隔
*           ->：传递的意思，把参数传递给方法体{}
*           {}：重写接口的抽象方法的方法体
*
* Lambda表达式的使用前提：
*	1、使用Lambda表达式必须具有接口，且要求接口中有且仅有一个抽象方法。
*		无论是JDK内置Runnable、Comparator接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
*	2、使用Lambda必须具有上下文推断
*		也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例
* 备注：有且仅有一个抽象方法的接口，称为“函数式接口”
* */
public class Demo02Lambda {
    public static void main(String[] args) {
        //使用匿名内部类的方式实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新的线程创建了");
            }
        }).start();


        /*
        * 使用Lambda表达式，实现多线程
        * “ () -> {System.out.println(Thread.currentThread().getName() + "新的线程创建了")} ”
        * Lambda表达式格式分析：
        *       前面的一对小括号即run方法的参数(无)，代表不需要任何条件
        *       中间的一个箭头代表将前面的参数传递给后面的代码
        *       后面的输出语句即业务逻辑代码
        * */
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "新的线程创建了");
        }).start();

        //优化省略Lambda
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "新的线程创建了")).start();
    }
}
