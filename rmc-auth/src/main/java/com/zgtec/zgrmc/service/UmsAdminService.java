package com.zgtec.zgrmc.service;
import com.zgtec.zgrmc.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  zkc
 * @date 2023/04/07
 */
@FeignClient("rmc-user")
public interface UmsAdminService {
    @GetMapping("/admin/login")
    UserDto loadUserByUsername(@RequestParam ("username")String username);
}
