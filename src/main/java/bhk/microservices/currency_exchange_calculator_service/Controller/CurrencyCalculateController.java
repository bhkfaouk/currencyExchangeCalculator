package bhk.microservices.currency_exchange_calculator_service.Controller;

import bhk.microservices.currency_exchange_calculator_service.models.CurrencyExchangeServerReq;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyRequest;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyResponse;
import bhk.microservices.currency_exchange_calculator_service.services.CurrencyCalculate;
import bhk.microservices.currency_exchange_calculator_service.services.CurrencyExchangeServiceProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@Slf4j
@RestController("/calculate")
@RequiredArgsConstructor
public class CurrencyCalculateController {
    private final CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
    private final CurrencyCalculate currencyCalculate;
    private final Environment environment;

    @PostMapping("/convert")
    public ResponseEntity<CurrencyResponse> convertValue(@RequestBody @Validated CurrencyRequest currencyRequest) throws IOException {
        CurrencyExchangeServerReq serverReq = new CurrencyExchangeServerReq(currencyRequest.getTargetCurrencyCode(),currencyRequest.getSourceCurrencyCode());
        log.info("serverReq: "+serverReq.toString());
        ResponseEntity<CurrencyResponse> responseEntity = currencyExchangeServiceProxy.getExchangeValue(serverReq);
        CurrencyResponse response = responseEntity.getBody();
        response.setTargetAmountConverted(currencyCalculate.calculate(currencyRequest.getSourceAmountToConvert(),response.getTargetAmountConverted()));

        return  ResponseEntity.ok(response);
    }






}
