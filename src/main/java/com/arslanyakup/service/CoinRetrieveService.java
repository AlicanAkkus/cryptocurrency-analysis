package com.arslanyakup.service;

import com.arslanyakup.dto.CryptoCurrency;

import java.util.List;

public interface CoinRetrieveService {

    List<CryptoCurrency> retrieve();

    CryptoCurrency retrieve(String coinId);
}