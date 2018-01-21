package com.arslanyakup.converter.coinmarketcap;

import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.http.request.coinmarketcap.CoinResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CoinMarketCapResponseConverter implements Function<CoinResponse, CryptoCurrency> {

    @Override
    public CryptoCurrency apply(CoinResponse coinResponse) {
        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(coinResponse.getId());
        cryptoCurrency.setName(coinResponse.getName());
        cryptoCurrency.setRank(coinResponse.getRank());
        cryptoCurrency.setUsdPrice(coinResponse.getPrice_usd());

        return cryptoCurrency;
    }
}
