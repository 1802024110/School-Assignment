# Spring AOP是什么
AOP（Aspect Orient Programming）是一种编程范型，它通过对横切关注点的抽象和模块化，使之能够被更好地复用和维护。

AOP 提供了一种使用简单的可插拔配置在实际逻辑之前，之后或周围动态添加横切关注点的方法。 现在和现在，维护代码都很容易。 您只需更改配置文件即可添加/删除关注点，而无需重新编译完整的源代码（如果您要使用要求 XML 配置的切面）。
> 注:
> - Spring AOP只能用于Spring管理的Bean中，对于其他的普通Java类或者非Spring管理的Bean则不起作用。
> - Spring AOP只支持方法级别的连接点，不支持属性级别的连接点。
> - Spring AOP使用了AspectJ的切点表达式语言，支持各种连接点指示符和操作符，比如execution、within、args等。

# Spring AOP的实现方式有两种
## 基于代理的经典AOP
基于代理的经典AOP使用Spring的AOP框架，它通过运行时创建一个代理对象来实现AOP。代理对象包装了目标对象，拦截并处理方法调用。
## 基于字节码的全面AOP
基于字节码的全面AOP使用AspectJ框架，它通过在编译期或类加载期间修改字节码来实现AOP。全面AOP比经典AOP更加强大，但是也更加复杂。

# 什么是建议，连接点和切入点
## 建议
建议是切面在特定连接点处采取的`操作`

建议与切入点表达式关联，并在与该切入点匹配的任何连接点处运行。

### 五种建议(操作)类型
1. 事前建议: 在连接点(执行)前执行的建议(操作)。除非报错，它不会阻止程序到链接点(执行)
2. 返回后建议: 在连接点(执行)正常完成后要执行的建议(操作)
3. 抛出后建议：如果方法因为抛出异常退出，则要执行的建议(操作)
4. 事后建议：无论连接(执行)点退出的方式如何，都将执行建议(操作)
5. 周围建议：它可以在方法调用前和之后自定义行为，还负责选择是返回连接点还是通过返回其自身的返回值或抛出异常来建议方法的执行。
## 连接点
是程序的执行点， 在 Spring AOP 中，连接点始终代表方法的`执行`。
## 切入点
是与连接点匹配的谓词或`表达式`。

# Maven 依赖
因为在spring boot中已经管理了这三个依赖，所以不需要写版本号
```pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
</dependency>

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
</dependency>
```