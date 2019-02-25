## 桥接模式

```
一.桥接模式
1.1 定义
把抽象化和实现化解耦，使得二者可以独立变化.
1.2 角色
业务抽象角色(Implementor).
业务实现角色(Abstraction).
二. 具体实现
2.1 创建业务实现的接口
    public interface IImplementor {
        void print();
    }
2.2 创建业务实现的具体实现类
    public class ImplementorA implements IImplementor{
        @Override
        public void print() {
            System.out.println(this.getClass().getSimpleName());
        }
    }
    public class ImplementorB implements IImplementor{
        @Override
        public void print() {
            System.out.println(this.getClass().getSimpleName());
        }
    }
2.3 创建业务抽象的抽象类
    public abstract class Abstraction {
        IImplementor implementor;
        public void print(){
            implementor.print();
        }
    }
2.4 创建业务抽象的实现类
    public class ConcreteAbstraction extends Abstraction{
        public ConcreteAbstraction(IImplementor implementor){
            super.implementor = implementor;
        }
        public void print(){
            super.print();
        }
    }
2.5 调用
    public static void main(String[] args) {
        Abstraction abstraction = new ConcreteAbstraction(new ImplementorA());
        abstraction.print();
        abstraction = new ConcreteAbstraction(new ImplementorB());
        abstraction.print();
    }
2.6 输出
    ImplementorA
    ImplementorB
    
三. 优缺点
3.1 优点
抽象与实现的解耦.
3.2 缺点
增加系统设计难度.

四. 参考：https://github.com/Seasons20/DisignPattern.git



     
```

- 参考 https://segmentfault.com/a/1190000014935223