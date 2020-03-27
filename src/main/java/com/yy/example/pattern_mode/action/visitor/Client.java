package com.yy.example.pattern_mode.action.visitor;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 18:41
 */
public class Client {

    public static void main(String[] args) {
        Car beijingCar = new Car();

        Engine engine = new Engine("发送机","解放牌，性能强劲");
        beijingCar.add(engine);
        Brand brand = new Brand("东风风行",1000, 10);
        beijingCar.add(brand);

        // 人人车的人想看下这个车的发送机性能和等级信息
        Visitor visitor = new RenRenCheVisitor();
        beijingCar.info(visitor);

        // 买新车的客户想看看这个车的发送机的新旧和牌子编号
        Visitor consumerVisitor = new ConsumerVisitor();
        beijingCar.info(consumerVisitor);

        // 即访问者你自己想了解车子的元素的信息，你自己打印出来就可以了。车子本身什么都不用动
    }
}
