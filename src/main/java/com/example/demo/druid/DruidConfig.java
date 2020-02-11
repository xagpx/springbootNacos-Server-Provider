package com.example.demo.druid;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import javax.sql.DataSource;
 
/**
 * druid监控控制台配置
 * http://localhost:port/druid
 */

@Configuration
public class DruidConfig {
  /*  @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {// 主要实现web监控的配置处理
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
                new StatViewServlet(), "/druid/*");//表示进行druid监控的配置处理操作
        //servletRegistrationBean.addInitParameter("allow", "127.0.0.1,192.168.202.233");//白名单
        //servletRegistrationBean.addInitParameter("deny", "192.168.202.234");//黑名单
        servletRegistrationBean.addInitParameter("loginUsername", "root");//用户名
        servletRegistrationBean.addInitParameter("loginPassword", "root");//密码
//        servletRegistrationBean.addInitParameter("resetEnable", "false");//是否可以重置数据源
        return servletRegistrationBean;
 
    }
 
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
 */
	@Bean
	public DataSource druidDataSource(){
	    return DruidDataSourceBuilder.create().build();
	}
}