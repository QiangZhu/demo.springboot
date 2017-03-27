theory:
	HandlerInterceptor 的功能跟过滤器类似，但是提供更精细的的控制能力：在request被响应之前、request被响应之后、视图渲染之前以及request全部结束之后。我们不能通过拦截器修改request内容，但是可以通过抛出异常（或者返回false）来暂停request的执行
	
	只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，比如我们自定义的Servlet地址 http://localhost:8080/xs/myservlet 是不会被拦截器拦截的。并且不管是属于哪个Servlet 只要复合过滤器的过滤规则，过滤器都会拦截
	
	实现 UserRoleAuthorizationInterceptor 的拦截器有： 
	ConversionServiceExposingInterceptor 
	CorsInterceptor 
	LocaleChangeInterceptor 
	PathExposingHandlerInterceptor 
	ResourceUrlProviderExposingInterceptor 
	ThemeChangeInterceptor 
	UriTemplateVariablesHandlerInterceptor 
	UserRoleAuthorizationInterceptor
	
	其中 LocaleChangeInterceptor 和 ThemeChangeInterceptor 比较常用。
	
	配置拦截器也很简单，Spring 为什么提供了基础类WebMvcConfigurerAdapter ，我们只需要重写 addInterceptors 方法添加注册拦截器。
	
	实现自定义拦截器只需要3步： 
	1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。 
	2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。 
	2、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。 
