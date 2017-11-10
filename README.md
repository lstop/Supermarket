## SSM框架的搭建

#### 导包

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.lstop</groupId>
	<artifactId>ssm01</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<!-- 自定义标签和标签所对应的值 -->
	<!-- 初始化框架的版本号 -->
	<properties>
		<spring.version>4.3.3.RELEASE</spring.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.1.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.shiro</groupId>
			<artifactId>shiro-spring</artifactId>
			<version>1.2.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.shiro</groupId>
			<artifactId>shiro-web</artifactId>
			<version>1.2.2</version>
		</dependency>
		<dependency>
			<groupId>org.apache.shiro</groupId>
			<artifactId>shiro-core</artifactId>
			<version>1.2.2</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		<!-- 加入ServletAPI -->
		<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-api</artifactId>
			<version>7.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.3</version>
			<scope>provided</scope>
		</dependency>
		<!-- MySQL依赖 start -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.24</version>
		</dependency>
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>0.2.23</version>
		</dependency>
		<!-- MySQL依赖 end -->
		<!-- 加入MyBatis 依赖 start -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.2.5</version>
		</dependency>
		<!-- 加入MyBatis 依赖 end -->
		<!-- Log4j start -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
		<!-- Log4j end -->
		<!-- 引入Spring(包含SpringMVC) 依赖 start -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-oxm</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- 引入Spring 依赖 end -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.2.2</version>
		</dependency>
		<!-- 引用插件依赖：MyBatis整合Spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.3.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core -->
		<dependency>
			<groupId>org.mybatis.generator</groupId>
			<artifactId>mybatis-generator-core</artifactId>
			<version>1.3.2</version>
		</dependency>
	</dependencies>
</project>
```

#### Spring的配置文件  applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

	<!--spring中用于开始注解的配置，必须有这句话才会使注解生效 -->
	<context:component-scan base-package="com.lstop"></context:component-scan>
	<!-- 初始化数据源,并且使用dbcp连接池，c3p0等连接池步骤相同 -->
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/ssm" />
		<property name="username" value="root" />
		<property name="password" value="root" />
		<!-- 初始化连接大小 -->
		<property name="initialSize" value="0"></property>
		<!-- 连接池最大数量 -->
		<property name="maxActive" value="20"></property>
		<!-- 连接池最大空闲 -->
		<property name="maxIdle" value="20"></property>
		<!-- 连接池最小空闲 -->
		<property name="minIdle" value="1"></property>
		<!-- 获取连接最大等待时间 -->
		<property name="maxWait" value="6000"></property>
	</bean>

	<!-- spring和MyBatis完美整合，不需要mybatis的配置映射文件 -->

	<!-- 之前我们写在mybatis_confgig中的配置， mappers也需要在这里进行配置 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<!-- 自动扫描mapping.xml文件 -->
		<property name="mapperLocations" value="classpath:com/lstop/pojo/*.xml"></property>

		<property name="typeAliasesPackage" value="com.lstop.pojo"></property>
	</bean>


	<!-- DAO接口所在包名，Spring会自动查找其下的类 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.lstop.dao" />
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
	</bean>
	
	<tx:annotation-driven transaction-manager="txManager" />
	<bean id="txManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<!-- (this dependency is defined somewhere else) -->
		<property name="dataSource" ref="dataSource" />
	</bean>
	<import resource="shiro-spring.xml" />
</beans>
```

#### SpringMVC的文件 springmvc.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!-- 添加扫描 -->
<!--添加视图解析器 -->
<!-- 这里是springmvc的核心配置文件 -->
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.1.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd">

	<!-- mvc其实spring的一个模块，所以他的配置文件的标签和spring是类似的 -->
	<!-- 设置扫描组件的包： -->
	<context:component-scan base-package="com.lstop"/>
	<!-- 配置映射解析器：如何将控制器返回的结果字符串，转换为一个物理的视图文件 -->
	<!-- springmvc会自动帮助我们做页面的转发，我们需要告知jsp文件所存在的位置 -->
	<bean id="internalResourceViewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/" />
		<property name="suffix" value=".jsp" />
	</bean>
	<!-- /WEB-INF/views/ login .jsp -->
</beans>
```

在web.xml中配置

```
<servlet>
		<servlet-name>springDispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!-- 配置DispatcherServlet的初始化參數：设置文件的路径和文件名称 -->
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classPath:springmvc.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>springDispatcherServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>

	<!-- 当服务器已启动就需要使用到ioc容器的功能，所以启动的时候就需要初始化ioc容器对象，我们可以通过对servletcontext的监听器来实现 -->

	<!-- spring已经提供了这么监听器，我们只需要对他进行注册 -->
	<!-- 监听serviletcontext对象，application启动的时候自动ioc容器初始化  -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	<!-- ContextLoaderListener中初始化ioc容器， 自动读取bean所在文件的时候默认的路径是/WEB-INF/applicationContext.xml.  
		我们可以通过以下修改来修改读取applicationContext.xml的路径  -->


	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
	</context-param>
	
	<filter>
		<filter-name>shiroFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		<init-param>
			<param-name>targetFilterLifecycle</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>shiroFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

