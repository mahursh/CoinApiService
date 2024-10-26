package com.ada.coindata.repository;


import com.ada.coindata.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin , Long> {

    List<Coin> findCoinByPriceUsdBetween(Double low , Double high);

}
