## spring 动态代理术语概念


### 连接点(JoinPoint)
```markdown
Aspect 在应用程序执行时加入业务流程的点，也可以说成是程序执行的某个特定位置：如类开始初始化前、类初始化后、类某个方法调用前、调用后、方法抛出异常后。这些代码中的特定点，称为“连接点”。
具体来说，就是 Advice 在应用程序中被呼叫执行的时机，这个时机可能是某个方法被呼叫之前或之后（或两者都有），或是某个异常发生的时候。(Spring AOP的连接点只能是方法)
连接点也可以说是加入AOP通知的地方
```

### 切入点(PointCut)
```markdown
决定在哪里的连接点上做通知操作

每个程序类都拥有多个连接点，如一个拥有两个方法的类，这两个方法都是连接点。但在这为数众多的连接点中，如何定位到某个感兴趣的连接点上呢？AOP通过“切入点”定位特定的连接点

在 Spring 中, 所有的方法都可以认为是Joinpoint, 但是我们并不希望在所有的方法上都添加 Advice, 
而 Pointcut 的作用就是提供一组规则(使用 AspectJ pointcut expression language 来描述) 来匹配Joinpoint, 
给满足规则的Joinpoint 添加 Advice。


```
### Advice(通知)
```markdown
通知(Advice)实际就是对主业务逻辑的一种增强，是一种在目标方法执行之外额外的方法。
    
如，日志处理–在目标方法执行前后添加日志。
这些被添加日志的方法称为连接点； 
通知方法执行的位置称为切入点； 
对目标方法增强的方法称为通知； 
对日志增强的所有通知方法所属的类称为切面。

```
综上，切入点定义切入的位置，通知定义切入的时机和增强功能。通知需要与切入点配合使用。


### Aspect(切面) Aspect is Advice + Pointcut
```markdown
切面由切入点和通知(Advice)组成，它既包括了横切逻辑的定义，也包括了连接点的定义，Spring AOP就是负责实施切面的框架，它将切面所定义的横切逻辑织入到切面所指定的连接点中。
```

### Advisor(增强器) 特殊的Aspect
```markdown
Advisor是一种特殊的Aspect，Advisor代表spring中的Aspect 。
```

### 织入(Weaving) 
```markdown
把切面加入程序代码的过程
织入是指将切面代码插入到目标对象的过程。代理的invoke方法完成的工作，可以称为织入。
```

### What is the difference between Advisor and Aspect in AOP?
```markdown
通知（Advice）和Advisor(增强器）

Advice is the way you take an action on your Pointcut.
You can use before, after or even around advice to apply any action you defined. 
Talking about Spring Aspect, it is only a class which is a high level and merge two concepts : jointpoint and advice.
It can be done through XML based blueprint, or programmatically.
Also you should specify your point where you want to plug in an aspect, it is done by using Jointpoint.

Also Spring Aspects and Advice aren't substitute for each other, because Aspects is only merger for jointpoint and advice.

Most aspects are a combination of advice that defines the aspect’s behavior and a pointcut defining where the aspect should be executed.

public interface PointcutAdvisor {
   Pointcut getPointcut();
   Advice getAdvice();
}
```
![advise_advisor关系图](https://github.com/yaoyuanyy/java_example/blob/master/picture/advisor_advice_pointcut.gif?raw=true)

### 举例解释术语
![实例说明](https://github.com/yaoyuanyy/java_example/blob/master/picture/aspect.png?raw=true)
如上图所示
整个类WebLogAspect是一个aspect(即Advisor), 标记有@Pointcut的表达式是切入点(Pointcut), @Before是一个通知(Advice)


### 参考
https://juejin.im/post/5b1ca657f265da6e5a205c45
https://juejin.im/post/5b2bc56b6fb9a00e325e7636
https://juejin.im/post/5b1ca657f265da6e5a205c45