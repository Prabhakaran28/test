package com.pabbu.anthemLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication

public class ApplicationBoot implements CommandLineRunner{
	
	@Configuration 
	public class ServiceConfig {
	    
	    public @Bean Details details() {
	        return new Details();	
	    }
	    

	}
	
	@Autowired
	private kafkaSend sender;
	
	public void run(String... strings) throws Exception {
        sender.send("Spring Kafka Producer and Consumer Example");
    }

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		((pabu) ctx.getBean("pabu")).yes();

		SpringApplication.run(ApplicationBoot.class, args);

	}
}
