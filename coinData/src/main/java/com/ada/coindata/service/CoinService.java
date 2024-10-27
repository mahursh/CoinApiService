package com.ada.coindata.service;


import com.ada.coindata.feign.CoinApiClient;
import com.ada.coindata.model.Coin;
import com.ada.coindata.repository.CoinRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CoinService {

    private final CoinApiClient coinApiClient;
    private final CoinRepository coinRepository;

    public CoinService(CoinRepository coinRepository, CoinApiClient coinApiClient) {
        this.coinApiClient = coinApiClient;
        this.coinRepository = coinRepository;
    }

    public Coin save(Coin coin) {
        return coinRepository.save(coin);
    }

    public List<Coin> saveAll(String token) {
        List<Coin> coinList = fetchAllCoinsData(token);
        return coinRepository.saveAllAndFlush(coinList);
    }

    public List<Coin> fetchAllCoinsData(String token) {
        List<Map<String, Object>> allCoinsMap = coinApiClient.getCoinData(token);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Coin> allCoinsList = allCoinsMap.stream().map(
                co ->{
                    JsonNode  coinsNode =objectMapper.convertValue(co , JsonNode.class);
                    Coin coin = new Coin();

                    if (coinsNode.has("asset_id")){
                        coin.setAsset(coinsNode.get("asset_id").asText());
                    }

                    if (coinsNode.has("name")){
                        coin.setName(coinsNode.get("asset_id").asText());
                    }

                    if (coinsNode.has("symbol")){
                        coin.setName(coinsNode.get("symbol").asText());
                    }

                    if (coinsNode.has("type")){
                        coin.setType(coinsNode.get("type").asText());
                    }

                    if (coinsNode.has("volume_24h")){
                        coin.setVolume(coinsNode.get("volume_24h").asDouble());
                    }

                    if (coinsNode.has("price_usd")){
                        coin.setPriceUsd(coinsNode.get("price_usd").asDouble());
                    }

                    if (coinsNode.has("supply")){
                        coin.setSupply(coinsNode.get("supply").asDouble());
                    }

                    if (coinsNode.has("last_updated")){
                        coin.setLastUpdated(LocalDateTime.parse(coinsNode.get("last_updated").asText()));
                    }

                    if (coinsNode.has("algorithm")){
                        coin.setAlgorithm(coinsNode.get("algorithm").asText());
                    }

                    if (coinsNode.has("mining_difficulty")){
                        coin.setMiningDifficulty(coinsNode.get("mining_difficulty").asDouble());
                    }

                    coin.setDeleted(false);
                    coin.setUpdated(LocalDateTime.now());
                    return coin;
                }).toList();
                return allCoinsList;

    }

    public Map<String, Object> fetchSingleCoinData(String token, String assetName) {
        return coinApiClient.getDataByAssetName(token, assetName);
    }


//    public List<Coin> allCoinsMapper(List<Map<String , Object>> allCoins){
//        List<Map<String , Object>>  coinsMap =  fetchAllCoinsData();
//    }


}
