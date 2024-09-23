package bhk.microservices.currency_exchange_calculator_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CurrencyResponse {
    private String message;


    private CurrencyCode targetCurrencyCode;    // The currency you want to convert to

    private CurrencyCode sourceCurrencyCode;    // The currency you're converting from

    private Double targetAmountConverted;      // The amount of money  converted to the target Currency

    private int serverPort;
}