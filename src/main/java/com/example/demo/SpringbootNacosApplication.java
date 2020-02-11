package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.alibaba.nacos.api.exception.NacosException;
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootNacosApplication {
	public static void main(String[] args) throws NacosException {
		SpringApplication.run(SpringbootNacosApplication.class, args);
	}
}
