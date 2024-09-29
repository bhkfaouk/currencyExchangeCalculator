package bhk.microservices.currency_exchange_calculator_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients("bhk.microservices.currency_exchange_calculator_service.services")
public class CurrencyExchangeCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeCalculatorServiceApplication.class, args);
	}

}
