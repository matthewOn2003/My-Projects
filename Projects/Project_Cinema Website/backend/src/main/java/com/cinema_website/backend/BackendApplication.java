package com.cinema_website.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@ComponentScan(basePackages = {"com.cinema_website.backend", "com.cinema_website.backend.config"})
public class BackendApplication {

//	@Autowired
//	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		emailService.sendEmail("onwuxu@gmai.com",
//							"This is wawa",
//							"This is miya");
//	}

}
