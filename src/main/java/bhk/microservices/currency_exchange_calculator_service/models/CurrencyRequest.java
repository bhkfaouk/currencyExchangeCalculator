package bhk.microservices.currency_exchange_calculator_service.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

@Validated
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyRequest {

    private CurrencyCode targetCurrencyCode;    // The currency you want to convert to

    private CurrencyCode sourceCurrencyCode;    // The currency you're converting from


    @NotNull(message = "sourceAmountToConvert cannot be null")
    @Positive(message = "sourceAmountToConvert must be greater than zero")
    private Double sourceAmountToConvert;      // The amount of money to be converted
}

