package com.practice.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title ="Accounts micro services REST API documentation",
				description = "ABC bank micro services REST API documentation",
				version = "v1",
				contact = @Contact(
						name = "Satish",
						email = "Sathish.m99@gmail.com",
						url="www.abcbank.com"
				),
				license = @License(
						name = "General License",
						url = "www.abcbank.com"
				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
