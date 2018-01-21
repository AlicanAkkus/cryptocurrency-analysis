package com.arslanyakup.controller;

import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.manager.CoinRetrieveManager;
import com.arslanyakup.service.CoinMarketCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private CoinRetrieveManager coinRetrieveManager;

    @Autowired
    private CoinMarketCapService coinMarketCapService;

    @GetMapping
    public List<CryptoCurrency> retrieveCoins() {
        return coinRetrieveManager.retrieve();
    }

    @GetMapping("/{coinId}")
    public CryptoCurrency retrieveCoin(@PathVariable String coinId) {
        return coinRetrieveManager.retrieve(coinId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter/minprice/{priceTry}")
    public Set<CryptoCurrency> filterByMinPrice(@PathVariable Integer priceTry) throws IOException {
        return coinMarketCapService.filterByMinPrice(priceTry);
    }

    // type is loss or profit
    @RequestMapping(method = RequestMethod.GET, value = "/filter/type/{type}/percentage/{percentage}")
    public List<CryptoCurrency> percentageProfit7d(@PathVariable String type, @PathVariable Double percentage) throws IOException {
        return coinMarketCapService.percentage7dStatus(type, percentage);
    }

    // type is increment or decrement
    @RequestMapping(method = RequestMethod.GET, value = "/sorted/{type}")
    public List<CryptoCurrency> sortedByPrice(@PathVariable String type) throws IOException {
        return coinMarketCapService.sortedByPriceTry(type);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/first/{value}")
    public Set<CryptoCurrency> topXCoins(@PathVariable Integer value) throws IOException {
        return coinMarketCapService.getTopXCoins(value);
    }
}