# 1. static 注意项

  1. 静态方法只能访问静态变量和方法 (没有this关键字类似于JS箭头函数)

  2. 非静态方法可以访问静态变量或者静态方法, 也可以访问非静态的成员变量和非静态的成员方法

  3. 静态方法中是没有this关键字

  4. 静态随着类的加载而加载; 非静态跟对象有关

  5. 静态变量会在内存堆生成一个静态储存位置(静态区)所有的同类对象都公用静态变量和方法,所有没有this关键字

     

# 2. 对象

## 1. 封装

## 2. 继承 protected

​	**注意:**  this 调用就近原则  super 调用 直接调用父类

	1. 构造方法 非私有 不能继承     private 不能继承
	1. 成员变量  非私有 能继承        private 能继承
	1.  成员方法  虚方法表 能继承    private 不能继承

​	虚方法表: 非private  非static  非final

​	父类的虚方法表 -> 子类虚方法表: 基于父类的虚方法表在添加到自己类中的虚方法表

4. 书写格式 @Override 重写注解

**注意:** (1)重写方法名称和形参必须与父类中的一致

​		  (2)必须要在虚方法表中的方法才能进行重写



```java
class Parent {
    public void foo () {
        System.out.println("Hello Word")
    }
}

class Child extends Parent {
	// 方法的重写 重写继承类的方法    
    @Override
    public void foo () {
        System.out.println("coderWhy")
    }
}
```



## 3. 多态

​	**前提:**  有继承/实现关系;

​			   有父类引用指向子类对象;

​			   有方法重写;

​	**好处:** 试用父类型昨晚参数, 可以接受所有子类对象,体现多态的扩展性和便利;

​	**多态调用成员的特点:**

​		变量调用: 编译看左边, 运行也看左边	

​		方法调用: 编译看左边, 运行看右边

```java
class Animal {
    String name = "动物";
    public void show () {
        System.out.println("Animal ... show 方法")
    };
}

class Dog extends Animal {
    String name = "狗";
    
    // 重写方法
    @Override
    public void show () {
        System.out.println("Dog ... show 方法")
    };
    
    public void lookHome () {
        System.out.println("狗看家")
    }
}

class Cat extends Animal {
    String name = "猫";
    
    @Override
    public void show () {
        System.out,println("Cat ... show 方法")
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建对象(多态方式)
        // parent par = new children()
        Animal a = new Dog();
        // 调用成员变量 编译看左边, 运行看左边,
        // 编译看左边: javac编译代码的时候会看左边的父类中有没有这个变量, 如果有则编译成功, 如果没有则编译失败(报错)
        // 运行看左边: javac编译代码的时候, 实际获取的是父类中的成员变量的值
        System.out.println(a.name); // "动物"
        
        // 调用成员方法: 编译看左边, 运行看右边
        // 编译看左边: javac编译代码的时候, 会看左边的父类中有没有这个方法, 如果有则编译成功, 如果没有则编译失败(报错)
        // 运行看右边: javac运行代码中, 实际上运行的是子类中的方法
        a.shouw(); // Dog ... show 的方法
    }
}

```

​	**弊端:** 无法调用子类独特的方法/变量

​		**解决方法:** 试用类型转换

```java
Dog d = (Dog)a; // 大转小 前面需要(类型)进行强制转换

// jdk 14 以上版本
// a 是否是 Dog类型 如果是强转为 d
if(a instanceof Dog d) {
    d.lookHome()
}
```

# 3. 包

​	**作用:**  类似于js中的模块化导入

​	**规制:**  书写规则 公司域名反写 + 包的作用 全英文小写

 1. 使用同一个包中的类时, 不需要导包

 2. 使用java.lang包中的类时, 不需要导包

 3. 其他情况都需要导包

    ```java
    // 包名为 com.scw.test 下的 Parent 类
    import com.scw.test.Parent;
    
    public class Test {
        public static void main(String[] agrs) {
            Parent p = new Parent();
        }
    }
    ```

    

 4.  如果同时使用两个包中同名类, 需要用全类名

    ```java
    public class Test {
        public static void main(String[] agrs) {
            // com.scw.test 包下的 Parent 类
            com.scw.test.Parent p = new com.scw.test.Parent();
            // com.scw.test2 包下的 Parent 类
            com.scw.test2.Parent p = new com.scw.test2.Parent();
        }
    }
    ```

# 4. final 

​	修饰符

1. **方法:**  表示该方法是最终方法, 不能被重写
1. **类:**  表示该类是最终类, 不能被继承
1. **变量:** 叫做常量, 只能被赋值一次 类似于 js 的 const 的配置常量   大写 + _ 拼接

# 5. 权限修饰符

​	**private < 默认(空) < protected <  public**

	1. private:  私有的, 只能在类的内部使用
	1. 默认:  只能在本包使用
	1. protected:  受保护的 本包和其子类可使用
	1. public: 公共的 所有地方都能使用

# 6. 代码块

 1. 局部代码块

 2. 构造代码块

    ```java
    public class Student {
        private String name;
        private int age;
        
        // 构造代码块
        {
            // 无论是 空参构造创建对象还是有参构造创建对象 都会先执行 构造代码块 再执行 构造函数
            System.out.println("开始创建对象了");
        }
        
        public Student () {
            
        }
        
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    ```

    

 3. 静态代码块(随着类的加载而加载, 只执行一次)

    ```java
    public class Student {
    	public String name;
        public int age;
        
        // 静态代码块 用于初始化变量
        static {
            // 添加用户信息
        }
        
        public Student () {}
        
        public Student (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    ```

    

# 7. 抽象类和抽象方法

​	abstract 修饰符

```java
public abstract class Person {
	public abstract void work();
}
```

	1. 抽象类不能实例化(创建对象)
	1. 抽象类中不一定有抽象方法, 有抽象方法的类一定是抽象类
	1. 可以有构造方法
	4. 抽象类的子类
	 	1. 要么重写抽象类中的所有抽象方法
	 	2. 要么是抽象类

# 8. 接口 (interface)

1.  接口的定义

```java
public interface 接口名称 {}
```

	2. 接口不能实例化
	2. 接口与类 之间是实现关系, 通过 **implements** 关键字表示

```java
public class 类名 implements 接口名 {}
```

 	4. 接口的子类(实现类)
 	 1. 要么重写接口中的所有抽象方法
 	 2. 要么是抽象类

**注意:**  接口和类的实现关系可以单实现,也可以多实现

```java
public class 类名 implements 接口名1, 接口名2 {}
```

​			实现类还可以再继承一个类的同时实现多个接口

```java
public class 类名 extend 父类 implements 接口名1, 接口名2 {}
```

**特点:** 

​	1. 成员变量:  只能是常量, 默认修饰符: public static final

​	2. 构造方法: 没有

​	3. 成员方法: 只能是抽象方法 , 默认修饰符 public abstract(

​	JDK7: 接口中只能定义抽象方法

​	JDK8: 接口添加了默认方法	public default void foo() {}; 

​				(1).  默认方法不会强制被重写, 重写的时候去掉default关键字

​				(2).  public 可以省略, default 不能省略

​				(3).  如果实现了多个接口, 多个接口存在相同名字的默认方法,子类就必须要对该方法重写

​			   接口添加了静态方法 **不需要被重写** public static void foo() {};

​				(1).   静态方法只能通过接口名调用, 不能通过实现类名或者对象调用

​				(2).  public 可以省略, static 不能省略

​	)

**默认方法:** 

```java
public interface Inter {
    public abstract void method();
    public default void show() {
        System.out.println("接口中的默认方法 ... show")
    };
}

public interface Inter2 {
    public abstract void method();
    public default void show() {
        System.out.println("接口中的默认方法 ... show")
    };
}

public class InterImp1 implements Inter {
    // 可以不重写 接口中的 show 方法
    
    @Override
    public void method () {
        System.out.println("实现类重写的抽象方法");
    }
    
    // 如果重写 则不需要加 default 
    @Override
    public void show() {
        System.out.println("实现类重写 show 的 默认方法");
    }
       
}

public class InterImp2 implements Inter, Inter2 {
    // 必须重写 接口中的 show 方法
    @Override
    public void method () {
        System.out.println("实现类重写的抽象方法");
    }
    
    @Override
    public void show() {
        System.out.println("实现类重写 show 的 默认方法");
    }
       
}
```

**静态方法:** 

```java
public interface Inter {
    public abstract void method();
    public static void show() {
        System.out.println("接口中的静态方法 ... show")
    };
}

public class InterImp1 implements Inter {
    // 不需要重写 show 方法 重写会报错
    
    @Override
    public void method () {
        System.out.println("实现类重写的抽象方法");
    }
    
    // 调用接口中的静态方法
    Inter.show();
       
}
```

​	JDK9: 接口添加了私有方法

```java
public interface Inter2 {
  public default void show() {
	System.out.println("show方法开始执行");
	show3();
  }

  public default void show2() {
	System.out.println("show方法开始执行");
	show3();
  }

  // 普通的私有方法 给默认的方法服务的
  private void show3() {
	System.out.println("哈哈哈哈哈");
  }

  // 静态的私有方法 给静态的方法服务的
  private static void show4() {
	System.out.println("哈哈哈哈哈");
  }
}
```

# 9. 适配器

 	**当一个接口抽象方法过多,但是我只要使用其中一部分的时候,就可以使用适配器设计模式**

​	书写步骤: 编写中间类XXXAdapter, 实现对应的接口对接口中的抽象方法进行空实现,然后让真正的实现类继承中间类,并且重写现需要用的方法, 为了避免对中间类的实例化, 对中间类添加 abstract 修饰符

# 10. 匿名内部类  

**<u>当一个方法只需要执行一次, 没必要new 一个对象 只需要使用匿名内部类重写该方法即可</u>**

​	书写格式: 

```java
new 类名或者接口名() {
    重写方法;
};

public class Test {
    public static void mian(argm[] string) {
        method(
        	new Animal() {
              @Override 
              public void eat() {
                  System.out.println("狗吃骨头")
              }
            };
        )
    }
    
    method(Animal a) { // Animal a = new 子类对象 多态
        a.eat()
    }
}
```

# 11. Object.clone

​	Object.clone 的修饰符是 protected (受保护的) 只能在 其本包(java.lang)或者子类中使用 **如果想要用clone方法必须要重写**

	1.  重写 Object 的 clone 方法
	1. 让 javabean 实现 Cloneable 接口
	1.  创建对象并调用clone方法

```java
public class Test {
    User u1 = new User();
}

// Cloneable
// 如果一个接口里没有抽象方法
// 表示当前接口为标记性接口 
// Cloneable一旦实现了那么当前类的对象就可以被克隆
// 如果没有实现 表示当前类不能被克隆

public class User implements Cloneable {
  
  // 必须重写clone方法 必须实现一个接口 Cloneable
  @Override
  protected Object clone() throws CloneNotSupportedException {
	// 调用父类中的clone方法
	return super.clone();
  }
}
```

# 11. 基本数据类型

 	 Bety、Short、Integer、Chart、String、Float、Duble、Long

# 12. 格式化时间

​	SimpleDateFormat 构造函数 

		1. 无参构造 默认的是 yyyy/MM/dd HH:mm:ss
		1. 有参构造 参数为 格式 例如 yyyy-MM-dd HH:mm:ss
	
	paser属性 解析格式化时间

​	format属性 格式化时间 

# 13. 日历对象

​	Calendar 抽象类 



1. ```java
   Calendar c = Calendar.getInstance(); // 返回一个 data 对象
   Date d = new Date(1000L * 60 * 60 * 24 * 365);
   ```

 2. ```java
    c.setTime(d); // 设置日历时间	
    ```

3. ```java
   Int year = c.get(1) // 获取某个字段的信息 年 
   Int month = c.get(2) + 1 // 获取某个字段的信息 月  
   Int day = c.get(3) // 获取某个字段的信息 日
   ```

4. ```java
   c.set(Calendar.YEAR, 2024) // 设置某个字段的信息 年设置为 2024
   c.add(Calendar.YEAR, 1) // 添加某个字段的信息 年添加 1 天
   ```
   

# 15. JDK8 - 时间类

### 	1. Period 

```java
Set<String> zoneIds = ZoneId.getAvailableZoneIds(); // 获取所有时区名称
ZoneId zd = ZoneId.systemDefault(); // 获取系统的时区
ZoneId zd = ZoneId.of("Asia/shanghai"); // 获取指定的时区
```

### 	2. Instant

```java
Instant now = Instant.now(); // 获取当前世界时间
Instant instant = Instant.ofEpochMilli(0L); // 获取世界时间 毫秒
```

### 	3. ZonedDateTime

```java
ZonedDateTime zonedDateTime = Instant.now().atZone(zd);// 获取当前时区的时间戳
```

### 	4. DateTimeFormatter

```java
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss EE a");
String format = dateTimeFormatter.format(zonedDateTime); // 格式化时间
```

### 	5. Period 一段时间的年、月、日，开使用between()方法获取两个日期之间的差

```java
LocalDate startDate = LocalDate.of(2015, 2, 20);
LocalDate endDate = LocalDate.of(2017, 1, 15);
 
Period period = Period.between(startDate, endDate);
```

### 	6. Duration 表示秒或纳秒时间间隔，适合处理较短的时间

```java
Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
Instant end = Instant.parse("2017-10-03T10:16:30.00Z");
         
Duration duration = Duration.between(start, end);
```

### 	7. ChronoUnit 类 Duration 和 Period 的所有单位都可以计算

```java

```

# 16. 常见算法

### 	1. 冒泡排序

### 	2. 选择排序

### 	3. 插入排序

```java
package array_search;

import java.util.Arrays;

// 插入排序 类似扑克牌的排序方法 max <- min 小往大的前面插入
public class InterDemo {
  public static void main(String[] args) {

    /*
      插入排序:
      将0索引的元素到N所有的元素看作有序的, 把N+1索引的元素到最后一个当成无需的
      遍历无序的数据,将遍历到的元素插入有序序列中适当的位置,如遇到相同的数据,插入在后面
      N的范围: 0~最大索引
     */

    int[] arr = {3, 44, 38, 5, 47, 15, 36, 27, 2, 46, 4, 19, 50, 48};

    // 1. 找到无序的那一组数据是从那个索引开始 2
    int startIndex = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > arr[i + 1]) {
       startIndex = i + 1;
       break;
      }
    }

    // 2. 遍历从 startIndex 开始到最后一个元素, 依次得倒无序中的那一组中的每一个元素
    for (int i = startIndex; i < arr.length; i++) {
      int j = i;
      while (j > 0 && arr[j] < arr[j - 1]) {
       // 交换位置
       int temp = arr[j];
       arr[j] = arr[j - 1];
       arr[j - 1] = temp;
       j--;
      }
    }

    System.out.println(Arrays.toString(arr));
  }
}
```

### 4. 快速排序

```java
package array_search;

import java.util.Arrays;

// 快速排序
public class QuickSort {
  public static void main(String[] args) {
    /*
      快速排序:
      第一轮: 以0索引的数字为基准数,确定基准数在数组中正确的位置.
      比基准数小的全部在左边, 比基准数大的全部在右边
      后面以此类推
     */

    int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

    quicksort(arr, 0, arr.length - 1);

    System.out.println(Arrays.toString(arr));
  }

  /**
   * 参数一: 要排序的数组
   * 参数二: 要排序的起始索引
   * 参数三: 要排序的结束索引
   */
  public static void quicksort(int[] arr, int i, int j) {
    // 定义两个变量要查找的范围
    int start = i;
    int end = j;

    // 递归出口
    if(start > end) {
      return;
    }

    // 记录基准数
    int bassNumber = arr[i];

    // 利用循环找到交换的数字
    while (start != end) {

      // 利用end, 找到比基准数小的数字
      while (arr[end] >= bassNumber && start < end) {
       end--;
      }

      // 利用start, 找到比基准数大的数字
      while (arr[start] <= bassNumber && start < end) {
       start++;
      }

      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
    }

    // 当start == end 那么上面的循环就会结束
    // 表示已经找到了基准数在数组中应存入的位置
    // 基准数归位
    arr[i] = arr[start];
    arr[start] = bassNumber;

    // 确定6左边的范围, 重复刚刚所做的事情
    quicksort(arr, i, start - 1);
    // 确定6右边边的范围, 重复刚刚所做的事情
    quicksort(arr, start + 1, arr.length - 1);

  }
}
```

# 17. lambda 表达式

### 	简化匿名内部类 -> 类似于 js 的箭头 函数 js 是 => ; lambad 是  <u>-></u>

### 	lambda 表达式 只能简化函数式接口的匿名内部类的写法

函数式接口: 有且只有一个抽象方法的<u>**接口**</u>叫做函数式接口, 接口上方可以加上@FunctionInterface注释

```java
Integer[] arr2 = {3, 44, 38, 5, 47, 15, 36, 27, 2, 46, 4, 19, 50, 48};

// 必须是包装类的数组 原代码匿名内部类
Arrays.sort(arr2, new Comparator<Integer>() {
	@Override
	public int compare(Integer o1, Integer o2) {
		return 0;
	}
});

// 简化后的匿名内部类
Arrays.sort(arr2, (o1, o2) -> 0);
```

### lambda表达式遍历数组以及单列集合

```java
Collection<String> strs = new ArrayList<>();
strs.add("aaa");
strs.add("bbb");
strs.add("ccc");

strs.forEach(item -> {
    System.out.println(item)
})
```

# 18. List 集合的遍历方式

### 	1. 迭代器遍历(删除元素)

```java
List<String> list = new ArrayList<>();
Iterator<String> it = list.iterator(); // 获取迭代器对象
while(it.hasNext()) {
   String str = it.next();
    System.out.println(str);
}
```

### 	2. 列表迭代器遍历(添加元素)

```java
List<String> list = new ArrayList<>();
ListIterator<String> it = list.ListIterator();
while(it.hasNext()){
    String str = it.next();
    if("bbb".equals(str)) {
        it.add("qqq"); // 在遍历迭代器中,不能用集合的add添加元素,否则报错, 只能用列表迭代器中的add的方法 
    }
    System.out.println(str);
}
```

### 	3. 增强for遍历

```java
List<String> list = new ArrayList<>();
for(String s, list) {
    s = 'aaa'; // 并不会修改list元素, 步骤是初始化s获取list的元素赋值给s
    System.out.println(s);
}
```



### 	4. Lambda表达式遍历

```java
List<String> list = new ArrayList<>();
list.forEach(s -> System.out.println(s))
```



### 	5. 普通for循环(因为List集合存在索引)

```
List<String> list = new ArrayList<>();
for(int i = 0; i < list.size(); i++) {
	String str = list.get(i);
	System.out.println(str);
}
```

# 19. ArrayList 底层原理

###   	1. 空参构造

				1. 利用空参构造的集合,在底层创建一个默认长度为0的数组
				1. 添加第一个元素的时候, 底层会创建一个新的长度为10的数组
				1. 存满时, 会扩容1.5倍
				1. 如果一次添加多个元素, 1.5倍还放不下,则新创建数组的长度以实际为准

# 20. 红黑树规则

1. 每一个节点都是红色的或者是黑色的(默认红色,效率高)

2. 根节点必须是黑色的

3. 叶节点是黑色的(null)

4. 两个红色节点不能相连

5. 任意节点到所有后代叶节点的简单路径上,黑色节点的数量是相同的

   

![](http://m.qpic.cn/psc?/V13bGCHq2JiKDh/ruAMsa53pVQWN7FLK88i5nXuiWQeBS*CMUUwrhVBI5vEM38dN6kc.j42JtAAWxr5JQqWMOY*qXE*ohtbB3zxdEoc5elG6bRHmVZsBOVzYfI!/b&bo=3gZdA94GXQMHFzY!&rf=viewer_4)

# 20. 方法的引用

### 使用方法一:  对象 :: 方法名(形参、返回值完全一样)

 <u>方法的引用前提条件</u>

1. 引用处必须是函数式接口
2. 被引用的方法必须是存在的
3. 被引用方法的形参和返回值需要更抽象方法保持一致
4. 被引用方法的功能要满足当前需求

```java
class Demo {
    public static void main(String ...agrm[]) {
        Integer[] arr = {1, 2, 3, 5, 6, 4};
        
        // Demo::subtraction 表示 引用 Demo类的subtraction 方法 把这个方法当作抽象方法体
        Arrays.sort(arr, Demo::subtraction)
    }
    
    public static int subtraction(int num1, int num2) {
        return num2 - num1
    }
}
```

### 使用方法二: 类名 :: 方法名(引用方法的形参和抽象方法第二个参数后面的一致)

 <u>方法的引用前提条件</u>

1. 引用处必须是函数式接口
2. 被引用的方法必须是存在的
3. 被引用方法的形参和抽象方法第二个参数后面的一致
4. 被引用方法的功能要满足当前需求

# 21. 线程的6种状态

创建->就绪->阻塞->无线等待(wait)->有限等待(sleep)->结束

# 22. 网络编程

####  	1. 什么是网络编程: 计算机与计算机之间通过网络进行数据传输

####  	2. 常见软件架构有哪些: CS/BS

​		CS: 客户端服务端模式,需要开发客户端

​		BS: 浏览器服务端模式,不需要开发客户端

# 23. 网络编程三要素: IP地址 端口号 协议

# 24. 传输层 TCP/UDP

#### 	1. UDP协议

​		用户数据报协议(User Datagram Protocol)

​		UDP是面向<u>**无连接通**</u>信协议(不会先检查网络是否连接)

​		 速度快,大小限制一次最多发送64k,数据不安全,易丢失数据

#### 	2. TCP协议

​		传输控制协议TCP(Transmission Control Protocol)

​		TCP协议是<u>**面向连接**</u>的通信协议

​		速度慢,没有大学限制,数据安全

# 25. TCP 三次握手/四次挥手

