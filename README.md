# springboot-basic
springboot项目的搭建和基本的用法
springboot整合jpa的简单使用


1.springboot的创建：
	idea的情况下，选择Spring Initializr 然后配置 web 和 devtools 一个是启动的web的核心依赖一个是开发工具包
2.创建热部署
	idea下，pom中修改 devtools的optional为true 则为热部署开启
	plugin 下增加configuration --》fork 为true
	接下来在build 里面选择自动构建；ctrl+shift+a：输入register 窜则compile.automake.allow.when.app.running
3.单元测试
	先创建mockmvc，静态的加载：ockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	mockmvc.perform()调用mockmvcRequestBuilders.post/get方法，.parm()加参数--》键值对类型,anddo（print()）可以打印
4json的支持
	在 Spring Boot 体系中，天然对 Json 支持，@restController
5.请求传参
	例如@RequestMapping(value="get/{name}", method=RequestMethod.GET)
	public User get(@PathVariable String name) {
		this.name = name;
	}
6.参数校验
	实体类上可以加@NotEmpty，@Max，@Min，@Length来设置属性的校验
	Spring Boot 的参数校验其实是依赖于 hibernate-validator 来进行
	public void saveUser(@Valid User user,BindingResult result){
		List<ObjectError> list = result.getAllErrors(); //能够得到所有的校验的结果
	}
7.自定义过滤
	自定义的过滤必须实现Filter接口并实现方法，在doFilter里面写上自己的过滤处理
	@Configuration说明是个配置类，用来存放配置信息，
	@bean 说明该方法作为一个配置信息被spring监控，
 	public FilterRegistrationBean testFilterRegistration() {
	   FilterRegistrationBean registration = new FilterRegistrationBean();
	   registration.setFilter(new MyFilter());
	   registration.addUrlPatterns("/*");
	   registration.addInitParameter("paramName", "paramValue");
	   registration.setName("MyFilter");
	   registration.setOrder(1);
	   return registration;
    }
8.自定义 Property
	配置在 application.properties 中
	然后在实体类中通过   @Value("${}")属性注入
