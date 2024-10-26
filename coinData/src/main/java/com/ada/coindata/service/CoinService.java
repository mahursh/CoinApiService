package com.ada.coindata.service;


import com.ada.coindata.feign.CoinApiClient;
import com.ada.coindata.model.Coin;
import com.ada.coindata.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoinService {

    private final CoinApiClient coinApiClient;
    private final CoinRepository coinRepository;

    public CoinService(CoinRepository coinRepository , CoinApiClient coinApiClient){
        this.coinApiClient = coinApiClient;
        this.coinRepository = coinRepository;
    }

    public Coin save(Coin coin){
       return coinRepository.save(coin);
    }

    public List<Coin> saveAll(List<Coin> coinList){
        return coinRepository.saveAll(coinList);
    }

    public List<Map<String , Object>> fetchAllCoinsData(String token){
        return coinApiClient.getCoinData(token);
    }

    public Map<String , Object> fetchSingleCoinData(String token , String assetName){
        return coinApiClient.getDataByAssetName(token , assetName);
    }


//    public List<Coin> allCoinsMapper(List<Map<String , Object>> allCoins){
//        List<Map<String , Object>>  coinsMap =  fetchAllCoinsData();
//    }





}
