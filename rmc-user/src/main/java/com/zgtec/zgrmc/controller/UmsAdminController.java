package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.pojo.dto.UmsAdminLoginDTO;
import com.zgtec.zgrmc.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkc
 * @description
 * @Date 2023/4/7 13:14 星期五
 * @Version 1.0
 */
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    private UmsAdminService umsAdminService;
    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
//    public Result login(@Validated @RequestBody UmsAdminLoginDTO umsAdminLoginDTO) {
    public Result login(@RequestParam ("username") String username) {
        UmsAdminLoginDTO umsAdminLoginDTO =new UmsAdminLoginDTO();
        return umsAdminService.login(umsAdminLoginDTO.getUserName(),umsAdminLoginDTO.getPassword());
    }
}
