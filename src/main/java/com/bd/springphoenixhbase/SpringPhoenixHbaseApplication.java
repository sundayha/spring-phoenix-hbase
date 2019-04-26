package com.bd.springphoenixhbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.bd.springphoenixhbase.*.mapper")
@EnableSwagger2
public class SpringPhoenixHbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPhoenixHbaseApplication.class, args);
	}

}
