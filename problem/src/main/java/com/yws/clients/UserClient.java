package com.yws.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
//    @GetMapping("user/{id}")
//    public User getById(@PathVariable int id);
}
