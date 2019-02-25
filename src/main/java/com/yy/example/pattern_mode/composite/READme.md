## 组合模式
定义：
```
组合模式也叫合成模式，有时又叫做部分-整体模式，主要是用来描述部分与整体的关系，将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
```

组合模式有两种实现：安全模式和透明模式

```
Component抽象构件角色
定义参加组合对象的共有方法和属性，可以定义一些默认的行为或属性。

Leaf叶子构件
Leaf叶子构件叶子对象，其下再也没有其他的分支，也就是遍历的最小单位。

Composite树枝构件
树枝对象，它的作用是组合树枝节点和叶子节点形成一个树形结构。组合模式的重点就在树枝构件。
```
使用场景
```$xslt
只要是树形结构或者只要是要体现局部和整体的关系的时候，而且这种关系还可能比较深，就要考虑一下组合模式。

从一个整体中能够独立出部分模块或功能的场景。

维护和展示部分-整体关系的场景。
```

### 安全模式和透明模式的具体实现
```$xslt
(1)安全模式
①抽象构件
public abstract class Component {
	//个体和整体都具有
	public void operation(){
		//编写业务逻辑
	}
}
复制代码
②树枝构件
public class Composite extends Component {
	//构件容器
	private List<Component> componentArrayList = new ArrayList<Component>();
	//增加一个叶子构件或树枝构件
	public void add(Component component){
		this.componentArrayList.add(component);
	}
	//删除一个叶子构件或树枝构件
	public void remove(Component component){
		this.componentArrayList.remove(component);
	}
	//获得分支下的所有叶子构件和树枝构件
	public List<Component> getChildren(){
		return this.componentArrayList;
	}
}
复制代码
③树叶构件
public class Leaf extends Component {
	/*
	* 可以覆写父类方法
	* public void operation(){
	*
	* }
	*/
}
复制代码
④Client
public class Client {
	public static void main(String[] args) {
		//创建一个根节点
		Composite root = new Composite();
		root.operation();
		//创建一个树枝构件
		Composite branch = new Composite();
		//创建一个叶子节点
		Leaf leaf = new Leaf();
		//建立整体
		root.add(branch);
		branch.add(leaf);
	}

	//通过递归遍历树
	public static void showTree(Composite root){
		for(Component c:root.getChildren()){
			if(c instanceof Leaf){ //叶子节点
				c.operation();
			}else{ //树枝节点
				showTree((Composite)c);
			}
		}
	}
}
复制代码
(2)透明模式
①抽象构件
public abstract class Component {
	//个体和整体都具有
	public void operation(){
		//编写业务逻辑
	}
	//增加一个叶子构件或树枝构件
	public abstract void add(Component component);
	//删除一个叶子构件或树枝构件
	public abstract void remove(Component component);
	//获得分支下的所有叶子构件和树枝构件
	public abstract List<Component> getChildren();
}
复制代码
②树枝构件
public class Composite extends Component {
	//构件容器
	private ArrayList<Component> componentArrayList = new ArrayList<Component>();
	//增加一个叶子构件或树枝构件
	public void add(Component component){
		this.componentArrayList.add(component);
	}
	//删除一个叶子构件或树枝构件
	public void remove(Component component){
		this.componentArrayList.remove(component);
	}
	//获得分支下的所有叶子构件和树枝构件
	public List<Component> getChildren(){
		return this.componentArrayList;
	}
}
复制代码
③树叶构件
public class Leaf extends Component {

	public void add(Component component){
		//空实现
	}

	public void remove(Component component){
		//空实现
	}

	public List<Component> getChildren(){
		//空实现
	}
}
复制代码
④Client
public class Client {

	public static void main(String[] args) {
		//创建一个根节点
		Composite root = new Composite();
		root.operation();
		//创建一个树枝构件
		Composite branch = new Composite();
		//创建一个叶子节点
		Leaf leaf = new Leaf();
		//建立整体
		root.add(branch);
		branch.add(leaf);
	}

	//通过递归遍历树
	public static void showTree(Component root){
		for(Component c:root.getChildren()){
			if(c instanceof Leaf){ //叶子节点
				c.operation();
			}else{ //树枝节点
				showTree(c);
			}
		}
	}
}

```

### 安全模式和透明模式的区别
```$xslt
安全模式在抽象组件中只定义一些默认的行为或属性，它是把树枝节点和树叶节点彻底分开；透明模式是把用来组合使用的方法放到抽象类中，不管叶子对象还是树枝对象都有相同的结构，通过判断确认是叶子节点还是树枝节点，如果处理不当，这个会在运行期出现问题，不是很建议的方式。

安全模式与依赖倒置原则冲突；透明模式的好处就是它基本遵循了依赖倒转原则，方便系统进行扩展。

安全模式在遍历树形结构的的时候需要进行强制类型转换；在透明模式下，遍历整个树形结构是比较容易的，不用进行强制类型转换。
```


### 实际应用
```
管理网站的菜单
-skyler管理后台
--人员
---教学人员
--地区
---东北
----黑龙江
---华南

第一级为root节点(component)，最后一级为叶子节点(leaf)，其他为树干节点(composite)
代码实现见project package: com.yy.example.pattern_mode.composite
```
- 参考 

https://segmentfault.com/a/1190000011988172
https://juejin.im/post/5aa0958f518825555e5d645c