## spring 动态代理名词概念

###

###

###

###

###

###

###


### What is the difference between Advisor and Aspect in AOP?
```
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
[]()
