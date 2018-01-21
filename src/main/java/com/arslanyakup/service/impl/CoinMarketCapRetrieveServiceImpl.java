package com.arslanyakup.service.impl;

import com.arslanyakup.constant.CoinMarketCapEndpointUri;
import com.arslanyakup.converter.coinmarketcap.CoinMarketCapResponseConverter;
import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.http.request.coinmarketcap.CoinResponse;
import com.arslanyakup.service.CoinRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(value = "coin.marketcap.retrieve.enabled", havingValue = "true")
public class CoinMarketCapRetrieveServiceImpl implements CoinRetrieveService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoinMarketCapResponseConverter coinMarketCapResponseConverter;

    @Override
    public List<CryptoCurrency> retrieve() {
        CoinResponse[] coins = restTemplate.getForObject(CoinMarketCapEndpointUri.ALL_COINS, CoinResponse[].class);

        return Arrays.stream(coins)
                .map(coinMarketCapResponseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public CryptoCurrency retrieve(String coinId) {
        CoinResponse[] coins = restTemplate.getForObject(CoinMarketCapEndpointUri.SELECTED_COINS, CoinResponse[].class, coinId);
        return Arrays.stream(coins)
                .map(coinMarketCapResponseConverter)
                .findAny().get();
    }
}