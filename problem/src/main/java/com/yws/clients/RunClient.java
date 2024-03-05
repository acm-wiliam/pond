package com.yws.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("executeservice")
public interface RunClient {
    @PostMapping("run")
    public String getRunResult(@RequestBody Map<String,String> param);
}
