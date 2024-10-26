package com.ada.coindata.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity(name = "coinEntity")
@Table(name = "coin_tbl")
public class Coin {

    @Id
    @SequenceGenerator(name = "coinSeq", sequenceName = "coin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coinSeq")
    @Column(name = "coin_id", nullable = false, unique = true)
    private Long id;

    @JsonProperty("asset_id")
    @Column(name = "coin_asset" ,columnDefinition = "NVARCHAR2(50)")
    private String asset;

    @JsonProperty("name")
    @Column(name = "coin_name" , columnDefinition = "NVARCHAR2(50)")
    private String name;

    @JsonProperty("symbol")
    @Column(name = "coin_symbol" ,columnDefinition = "NVARCHAR2(50)")
    private String symbol;

    @JsonProperty("type")
    @Column(name = "coin_type" ,columnDefinition = "NVARCHAR2(50)")
    private String type;

    @JsonProperty("volume_24h")
    @Column(name = "coin_volume" ,columnDefinition = "DOUBLE PRECISION")
    private Double volume;

    @JsonProperty("price_usd")
    @Column(name = "coin_price" ,columnDefinition = "DOUBLE PRECISION")
    private Double priceUsd;

    @JsonProperty("supply")
    @Column(name = "coin_supply" ,columnDefinition = "DOUBLE PRECISION")
    private Double supply;

    @JsonProperty("last_updated")
    @Column(name = "coin_lastUp" ,columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdated;

    @JsonProperty("algorithm")
    @Column(name = "coin_alg" ,columnDefinition = "NVARCHAR2(50)")
    private String algorithm;

    @JsonProperty("mining_difficulty" )
    @Column(name = "coin_md",columnDefinition = "DOUBLE PRECISION")
    private Double miningDifficulty;

    @Column(name = "coin_deleted", columnDefinition = "NUMBER(1) DEFAULT 0")
    private Boolean deleted = false;

    @Column(name = "coin_updated", columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;

}
