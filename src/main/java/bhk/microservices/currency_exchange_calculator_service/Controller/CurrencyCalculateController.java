package bhk.microservices.currency_exchange_calculator_service.Controller;

import bhk.microservices.currency_exchange_calculator_service.models.CurrencyExchangeServerReq;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyRequest;
import bhk.microservices.currency_exchange_calculator_service.models.CurrencyResponse;
import bhk.microservices.currency_exchange_calculator_service.services.CurrencyCalculate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@Slf4j
@RestController("/calculate")
@RequiredArgsConstructor
public class CurrencyCalculateController {
    private final CurrencyCalculate currencyCalculate;
    private final Environment environment;
    @PostMapping("/convert")
    public ResponseEntity<CurrencyResponse> getExchangeValue(@RequestBody @Validated CurrencyRequest currencyRequest) throws IOException {
        CurrencyExchangeServerReq serverReq = new CurrencyExchangeServerReq(currencyRequest.getTargetCurrencyCode(),currencyRequest.getSourceCurrencyCode());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity with headers and body
        HttpEntity<CurrencyExchangeServerReq> requestEntity = new HttpEntity<>(serverReq, headers);
        ResponseEntity<CurrencyResponse> responseEntity = new RestTemplate().postForEntity("http://localhost:8001/convert",requestEntity,CurrencyResponse.class);

        CurrencyResponse currencyResponse = responseEntity.getBody();
        currencyResponse.setTargetAmountConverted(currencyCalculate.calculate(currencyRequest.getSourceAmountToConvert(),currencyResponse.getTargetAmountConverted()));

        log.info("request :{}",currencyResponse + " from the user" + currencyRequest.getSourceAmountToConvert());
        log.info("response :{}",currencyResponse);
        return ResponseEntity.ok(currencyResponse);
    }

}
