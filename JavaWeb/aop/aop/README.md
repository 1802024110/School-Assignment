# Spring AOP是什么
AOP（Aspect Orient Programming）是一种编程范型，它通过对横切关注点的抽象和模块化，使之能够被更好地复用和维护。  
AOP 提供了一种使用简单的可插拔配置在实际逻辑之前，之后或周围动态添加横切关注点的方法。 现在和现在，维护代码都很容易。 您只需更改配置文件即可添加/删除关注点，而无需重新编译完整的源代码（如果您要使用要求 XML 配置的切面）。
> 注:
> - Spring AOP只能用于Spring管理的Bean中，对于其他的普通Java类或者非Spring管理的Bean则不起作用。
> - Spring AOP只支持方法级别的连接点，不支持属性级别的连接点。
> - Spring AOP使用了AspectJ的切点表达式语言，支持各种连接点指示符和操作符，比如execution、within、args等。

# AOP可以做什么
面向切面编程常用于日志记录、性能监控、事务管理等场景.常见地拦截器也是AOP

# Spring AOP的两种代理
可以通过`@EnableAspectJAutoProxy(proxyTargetcass=false)`强制启用JDK AOP
## 基于动态代理的JDK AOP
JDK动态代理只能对实现了接口的类生成代理，而不能针对类。  
优点
- 轻量级
- Java自带的

缺点
- 只能代理实现了接口的类
- 只能代理接口中的方法，对于类中的非接口方法无法进行代理。
## 基于动态代理的CGLIB AOP(新版本默认选择)

# 什么是连接点、切入点、切面、通知/增强处理、目标对象、织入、代理和引介
## 切面（Aspect）
切面由一个Advice和一个Pointcut组成，它定义了在何时、何处和何种情况下执行Advice。在实际的代码中指的是关注点(指类中`重复`的代码)形成的类。
## 连接点（Join point）
在应用程序执行期间，可以插入切面的点称为连接点，例如方法调用或异常处理程序。在 Spring AOP 中，连接点始终代表方法的`执行`。
## 切入点（Pointcut）
在AOP中，切入点指的是一组连接点，AOP框架可以在这些连接点上执行通知。一般来说，`切入点是使用表达式来定义`的，这个表达式指定了哪些连接点是需要被拦截的，可以使用通配符来匹配多个连接点。例如，在Spring AOP中，可以使用AspectJ切入点表达式语言来定义切入点，例如：
```java
@Pointcut("execution(* com.example.demo.service.*.*(..))")
private void serviceLayer() {}
```
面的代码定义了一个名为serviceLayer的切入点，它匹配com.example.demo.service包中的所有方法。。这里，execution表达式指定了要匹配的方法，通配符*表示任意返回类型和任意方法名，两个点..表示任意参数列表。这个切入点可以被用于定义切面。  
在其他切面中，可以使用这个切入点来定义切面。
```java
@Aspect
@Component
public class MyAspect {
    @Before("serviceLayer()") // 这里引用了切入点
    public void beforeAdvice() {
        //在serviceLayer切入点之前执行的操作
    }
}

```
## 通知(建议)/增强处理（Advice/Interceptor）
通知是切面的一部分，它就是插入切面的具体代码。增强处理是另一种术语，它与通知的含义相同。
## 目标对象（Target object）
要应用切面的对象称为目标对象。（被插入切面的方法）
## 织入（Weaving）
将切面应用到目标对象并创建新代理对象的过程称为织入。
## 代理（Proxy）
代理是包装目标对象的对象，客户端通过代理与目标对象进行交互。
## 引介（Introduction）
引介允许我们向现有类添加新方法或属性，它可以将新方法添加到目标对象中，从而扩展目标对象的功能。

### 五种建议(操作、通知、增强处理)类型
1. 事前(前置)建议（Before advice）: 在连接点(执行)前执行的建议(操作)。除非报错，它不会阻止程序到链接点(执行)
2. 后置建议（After advice）：在目标方法执行之后执行的建议。后置建议的方法不会访问连接点上的参数，但是可以访问方法的返回值或抛出的异常。
3. 返回建议（After returning advice）：在目标方法成功执行并返回之后执行的建议。返回建议的方法可以访问连接点上的返回值，并在目标方法返回后执行某些操作。
4. 异常建议（After throwing advice）：在目标方法抛出异常时执行的建议。异常建议的方法可以访问连接点上的异常，并在目标方法抛出异常后执行某些操作。
5. 环绕建议（Around advice）：在目标方法之前和之后执行的建议。环绕建议的方法可以控制何时执行目标方法，可以访问连接点上的参数、返回值和异常，并在目标方法执行前后执行某些操作。[0]
## 连接点
是程序的执行点， 在 Spring AOP 中，连接点始终代表方法的`执行`。
## 切入点
是与连接点匹配的谓词或`表达式`。

# Maven 依赖
因为在spring boot中已经管理了这个依赖，所以不需要写版本号
```pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

# 哔哩哔哩视频
【史上最完整的AOP底层原理】 https://www.bilibili.com/video/BV1SY41117zq/?share_source=copy_web&vd_source=f77963ff79cbf1a96a127bb3743d6734