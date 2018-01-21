package com.arslanyakup.manager;

import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.service.CoinRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinRetrieveManager {

    @Autowired
    private CoinRetrieveService coinRetrieveService;

    public List<CryptoCurrency> retrieve() {
        return coinRetrieveService.retrieve();
    }

    public CryptoCurrency retrieve(String coinId) {
        return coinRetrieveService.retrieve(coinId);
    }
}