package com.example.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.JDBCCall.JDBCStoredProcedureRead;
import com.example.demo.model.DmCnDvSuDung;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

}
