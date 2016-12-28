spring-springmvc-mybatis整合 模板

所用技术

1、日志记录 log4j 1.2.17
2、单元测试 junit 4.12

3、数据源 DRUID  1.0.26
4、mysql驱动 mysql 5.1.38

5、mybatis  3.4.1
6、mybatis-spring 1.3.0

7、spring context 4.3.4.RELEASE
8、spring jdbc
9、spring web
10、aspectj spring aop注解支持
    aspectjrt 1.8.9
    aspectjweaver 1.8.9
    
11、spring webmvc
12、jstl标准标签库
    jstl 1.2
    standard 1.1.2
13、mvc json支持
    jackson-databind  2.8.5
14、mvc 文件上传支持
    commons-fileupload  1.3.1
    commons-io          2.4
15、mvc 校验
    hibernate-validator 5.4.0.Beta1
    org.jboss.logging   3.3.0.Final
    javax.validation validation-api 1.1.0.Final
  
    
整合步骤：
1、加载spring容器
    在resource目录中创建applicationContext.xml配置文件
    web.xml中配置ContextLoaderListener监听器

2、spring管理数据源

3、spring整合mybatis
    3.1 注入sqlSessionFactory(事先创建好mybatis配置文件： mybatis-config.xml)
    3.2 自动扫描mapper.xml文件
    3.3 spring管理mybatis的事务
    3.4 配置log4j.properties(不是必须的)

4、springmvc配置
    4.1 配置前端控制器 web.xml中配置dispatchServlet
    4.2 配置适配器、映射器支持注解
    4.3 自动扫描controller(自动扫描组件)
    4.4 配置视图解析器 InternalResourceViewResolver
    4.5 支持文件上传


使用方法及注意事项

注意事项
1.不建议使用hibernate的校验器
2.mapper.xml文件仍需要在mybatis-config文件中配置
3.

使用方法
1、
    <!-- 加载Spring容器 -->
      <context-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:applicationContext.xml</param-value>
      </context-param>
      <listener>
          <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>

2、
    <!--======================配置数据源=======================-->
      <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
          <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
          <property name="url" value="jdbc:mysql:///test?useSSL=false"/>
          <property name="username" value="root"/>
          <property name="password" value="root"/>
      </bean>

3.1
    <!--=====================配置SqlSessionFactory=============-->
       <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           <property name="dataSource" ref="dataSource"/>
           <property name="configLocation" value="classpath:mybatis-config.xml"/>
       </bean>
3.2
    <!--====================配置自动扫描mapper.xml文件===========-->
       <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
           <property name="basePackage" value="com.it"/>
           <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
       </bean>
3.3
    <!--=====================配置事务管理============= ===========-->
       <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
           <property name="dataSource" ref="dataSource"/>
       </bean>
       <tx:annotation-driven transaction-manager="transactionManager"/>
3.4略

4.1
    <!--mvc前端控制器-->
       <servlet>
           <servlet-name>springmvc</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:springmvc.xml</param-value>
           </init-param>
       </servlet>
       <servlet-mapping>
           <servlet-name>springmvc</servlet-name>
           <!--
               第一种：*.action 访问以.action结尾 由DispatcherServlet进行解析
               第二种：/        所有访问都由DispatcherServlet进行解析对于静态文件的解析需配置不让DispatcherServlet解析
                               此种方式可以实现RESTful风格的url
           -->
           <url-pattern>*.action</url-pattern>
       </servlet-mapping>
4.2
    <!--=====================基于注解配置适配器，映射器=================-->
       <mvc:annotation-driven/>
4.3
    <!--=====================配置自动扫描controller====================-->
       <context:component-scan base-package="com.it.action"/>
4.4
    <!-- =================== 配置SpringMVC的视图解析器 =============== -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
       </bean>
4.5
    <!--==============支持文件上传=============================-->
       <bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver" id="multipartResolver">
           <property name="maxUploadSize" value="5242880"/>
       </bean>
