package bhk.microservices.currency_exchange_calculator_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyExchangeServerReq {

    private CurrencyCode targetCurrencyCode;    // The currency you want to convert to

    private CurrencyCode sourceCurrencyCode;    // The currency you're converting from

}
