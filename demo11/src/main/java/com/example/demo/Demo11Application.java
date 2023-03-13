package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

//import com.example.demo.controller.MyController;


@ComponentScan({ "com.example.demo.services" })
@SpringBootApplication
//@ComponentScan(basePackageClasses=MyController.class)
public class Demo11Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo11Application.class, args);
	}

}
