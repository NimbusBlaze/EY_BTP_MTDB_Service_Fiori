package com.example.demo;

//@SpringBootApplication
//public class MtdbserviceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MtdbserviceApplication.class, args);
//	}
//
//}

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.processor.MyODataServiceFactory;
import com.example.demo.entities.AddressOdataAgent;
import com.example.demo.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo") 
@ServletComponentScan(basePackages = "com.example.demo")
@EnableAsync
public class MtdbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtdbserviceApplication.class, args);
	}
	
	@Bean(name="com.example.demo.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory(){
		return new MyODataServiceFactory("com.example.demo");
	}
	
	@Bean(name="com.example.demo.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent(){
		return new VendorODataAgent();
	}
	
	@Bean(name="com.example.demo.entities.addressODataAgent")
	public AddressOdataAgent addressODataAgent(){
		return new AddressOdataAgent();
	}

}

