package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.api.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author  zkc
 *
 */
@FeignClient("rmc-auth")
public interface AuthService {
    @PostMapping(value = "/oauth/token")
    /**
     * 获取token
     * @param parameters
     * @return
     */
    Result getAccessToken(@RequestParam Map<String, String> parameters);
}
