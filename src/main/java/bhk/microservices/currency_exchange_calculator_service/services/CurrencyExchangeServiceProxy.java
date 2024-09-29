package bhk.microservices.currency_exchange_calculator_service.services;

import bhk.microservices.currency_exchange_calculator_service.models.CurrencyExchangeServerReq;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyRequest;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyResponse;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

//@FeignClient(name = "currency-exchange-service" , url = "localhost:8001")
@FeignClient(name = "currency-exchange-service")
///*//*/@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @PostMapping("/exchangeValue")
    public ResponseEntity<CurrencyResponse> getExchangeValue(@RequestBody CurrencyExchangeServerReq serverReq) throws IOException;

}
