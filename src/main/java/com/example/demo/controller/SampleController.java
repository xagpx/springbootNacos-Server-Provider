package com.example.demo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.example.demo.model.User;
import com.example.demo.util.ReturnT;
@RestController
@RefreshScope
class SampleController {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Value("${user.password}")
	String userName;

 	@Value("${user.name}")
	String name;

  	@Value("${user.age}")
	int age;
  	
  	@Autowired
    private ApplicationContext ctx;
  	
  	
	@RequestMapping("/user")
	public String simple() throws SQLException {
		return "获取 Nacos Config配置如下：" + userName + " " + name + "|" + age + "!";
	}
	
	@RequestMapping("/users/{id}")
    public ReturnT<User> getUserById(@PathVariable("id") String id) {
        return jdbcTemplate.queryForObject("select id,name,email from user where id = " + id, (ResultSet rs, int rowNum) -> {
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            return new ReturnT<User>(u);
        });
    }
	  
	 @GetMapping("/durid/stat")
	    public Object druidStat(){
	        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
	        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
	    }
	 
	 @RequestMapping("/query")
	    public String query(){
			System.out.println(new Date());
	      return "1";
	   }
}