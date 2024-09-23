package bhk.microservices.currency_exchange_calculator_service.services;

import org.springframework.stereotype.Service;

@Service
public class currencyCalculateImpl implements CurrencyCalculate {
    @Override
    public double calculate(double targetAmount, double targetCurrencyRate) {
        return targetAmount * targetCurrencyRate;
    }
}
