package xyz.leeyangy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.*;

/**
 * Hello world!
 */
//函数式接口,只要是函数式接口可以用lambda进行简化
//函数式接口,接口中有且只有未实现的方法叫做函数式接口
interface MyInterface {
    int sum(int i, int j);

    //    接口中的默认方法
    default int sub(int i, int j) {
        return i - j;
    }
}

class MyInterfaceImpl implements MyInterface {
    /**
     * @param i
     * @return
     */
    @Override
    public int sum(int i, int j) {
        return i + j;
    }
}

interface MyInterfaces {
    int sum();
}

interface MyInterfacess {
    int sum(int i);
}

interface MyDisplay {
    void print();
}

public class Lambda {
    public static void main(String[] args) {
//        1.传统写法,自己创建实现对象
        MyInterface myInterface = new MyInterfaceImpl();
        System.out.println("myInterface.sum(1,2) = " + myInterface.sum(1, 2));
//        2.创建匿名实现类
        MyInterface myInterface1 = new MyInterface() {
            /**
             * @param i
             * @param j
             * @return
             */
            @Override
            public int sum(int i, int j) {
                return i * i + j * j;
            }
        };

        System.out.println("myInterface1.sum(1,4) = " + myInterface1.sum(1, 4));

//        3. Lambda 表达式写法1 冗余写法    参数列表 + 箭头 + 方法体
        MyInterface myInterface2 = (int i, int j) -> {
            return i * i * i + j * j * j;
        };
        System.out.println("myInterface2 = " + myInterface2.sum(2, 2));


        MyInterface myInterface4 = (a,b) -> a*b;
        System.out.println("myInterface4 = " + myInterface4.sum(1,2));

//        3. Lambda 表达式写法2 简写    参数列表参数类型可以不写，参数变量名自定义 + 箭头 + 方法体
        MyInterface myInterface3 = (i, j) -> {
            return i * i * i + j * j * j;
        };
        System.out.println("myInterface2 = " + myInterface2.sum(2, 2));


        MyInterfaces myInterfaces = () -> {
            return 1;
        };

//        参数表最少可以只有一个
        MyInterfacess myInterfacess = y -> {
            return y * y;
        };

//        方法只有一句话，{}可以省略
        MyDisplay display = () -> System.out.println("6666");

        display.print();

//        List<String> names = new ArrayList<>();
        var names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Jack");
        names.add("Blue");
        names.add("David");
        names.add("Gan");
        // 使用 Lambda 表达式作为参数传递给sort方法
        //        原生比较器
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return t1.compareTo(s);
//            }
//        });
        // 简化1
//        Collections.sort(names, (String a, String b) -> a.compareTo(b));
//        简化2  a比b 顺序  b比a 倒序
//        Collections.sort(names, (a, b) -> a.compareTo(b));

        Collections.sort(names, String::compareTo);
        names.forEach(System.out::println);

//        线程1
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("hhhhhh");
                    }
                }
        ).start();

//        线程2
        new Thread(
                // 调用某个方法的传入参数，这个参数实例是一个接口对象，且只定义了一个方法，就直接用lambda表达式进行简化
                () -> System.out.println("hhhhh")
        ).start();


        /**
         * java中，函数式接口只包含一个抽象方法的接口，它们是支持lambda表达式的基础，因为lambda需要一个目标类型，这个了目标类型必须是一个函数式接口
         *
         * Function
         *  函数式接口的出入参定义：
         *      有入参，无出参[消费者]     function.accept     消费(别人的)数据，不需要返回什么东西
         *          BigConsumer<String,String> consumer = (a,b) ->{
         *              System.out.println("a = " + a+ ":" + "b = " + b);
         *          }
         *          consumer.accept("1","2");
         *          console: a = 1:b = 2
         *
         *      有入参，有出参[多功能函数]     function.apply
         *          Function function= (String s) -> Integer.parseInt(s);
         *          System.out.println(function.apply("111"));
         *          console: 111
         *
         *      无入参，有出参[数据提供者]     function.get()
         *          Supplier<String> supplier = () -> UUID.randomUUID().toString();
         *          System.out.println(supplier.get());
         *
         *      无入参，无出参[普通函数]
         *          Runnable runnable = () -> System.out.println();
         *          new Thread(runnable).start();
         */

        BiFunction<String, Integer, Long> biFunction = (a, b) -> 8L;
        System.out.println("biFunction.apply(\"1\",1) = " + biFunction.apply("1", 1));


//        Predicate 验证数据
        Predicate<Integer> predicate = p -> p % 2 == 0;
        System.out.println("predicate.test(1) = " + predicate.negate().test(1));

//        转换器，把字符串转成数字 类::实例方法(静态方法)
        Function<String, Integer> change = Integer::parseInt;
        System.out.println("change.apply(\"666\") = " + change.apply("666"));

//        消费者 打印数字
        Consumer<Integer> consumer = integer -> {
            if (integer % 2 == 0) System.out.println("integer = " + integer);
            else System.out.println("integer = " + integer);
        };

//        串在一起应用
        Supplier<Integer> supplier = () -> {
            return 2;
        };
//        简写
//        Supplier<Integer> supplier = () -> 2;

        if (predicate.test(supplier.get())) {
            System.out.println("odd");
            consumer.accept(change.apply(String.valueOf(supplier.get())));
        } else {
            System.out.println("even");
        }

        mymethod(
                () -> "666",
                arg -> arg.matches("-?\\d+(\\.\\d+)?"),
                arg -> Integer.parseInt(arg),
                System.out::println
        );
        mymethod(
                () -> "666",
                arg -> arg.matches("-?\\d+(\\.\\d+)?"),
                Integer::parseInt,
                System.out::println
        );

    }

    private static void mymethod(Supplier<String> supplier,
                                 Predicate<String> predicate,
                                 Function<String, Integer> function,
                                 Consumer<Integer> consumer
    ) {
        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        } else {
            System.out.println("不理想的数据");
        }
    }

    /**
     * 我目前的理解：
     *    以前的编程流程：
     *      定义一个接口，
     *      然后实现接口/重写方法
     *    引入了 Lambda 表达式后，优化了上述两个流程
     *    以 MyInterface 举例
     *      interface MyInterface {
     *         int sum(int i, int j);
     *
     *         //    接口中的默认方法
     *         default int sub(int i, int j) {
     *             return i - j;
     *         }
     *     }
     *
     *     class MyInterfaceImpl implements xyz.leeyangy.MyInterface {
     *         @Override
     *         public int sum(int i, int j) {
     *             return i + j;
     *         }
     *     }
     *
     *      将上述流程简化后，得到如下
     *          3. Lambda 表达式写法1 冗余写法    参数列表 + 箭头 + 方法体
     *         MyInterface myInterface2 = (int i, int j) -> {
     *             return i * i * i + j * j * j;
     *         };
     *         System.out.println("myInterface2 = " + myInterface2.sum(2, 2));
     *
     *         MyInterface myInterface4 = (a,b) -> a*b;
     *         System.out.println("myInterface4 = " + myInterface4.sum(1,2));
     *
     *         底层应该是帮我们做了我们以前写的实现方法？
     */



}
