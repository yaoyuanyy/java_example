## spring framework中使用的设计模式

 
#### 一. 观察者模式
```markdown
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

ApplicationListener

```
#### 二. 代理模式
```
为其他对象提供一种代理以控制对这个对象的访问。 从结构上来看和Decorator模式类似，但Proxy是控制，更像是一种对功能的限制，而Decorator是增加职责。

spring的Proxy模式在aop中有体现，比如JdkDynamicAopProxy和Cglib2AopProxy。


```

#### 三. 策略模式
```
定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。

spring中在实例化对象的时候用到Strategy模式，在SimpleInstantiationStrategy

ParameterMethodNameResolver
```
    
#### 四. 模板方法模式
```
定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

JdbcTemplate



```
#### 五. 
```

```

#### 六. 
```

```