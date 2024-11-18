package com.ada.coindata.feign;



import org.springframework.http.HttpHeaders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;



import java.util.List;
import java.util.Map;

@FeignClient(name = "coinApiClient" , url = "https://rest.coinapi.io" )
public interface  CoinApiClient {

    @GetMapping("/v1/assets")
    List<Map<String, Object>> getCoinData(@RequestHeader(HttpHeaders.AUTHORIZATION) String apiToken);

    @GetMapping("/v1/assets/{asset_id}")
    Map<String , Object> getDataByAssetName(@RequestHeader(HttpHeaders.AUTHORIZATION) String apiToken ,
                            @PathVariable("asset_id") String assetId);
}
