package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.dto.UmsAdminLoginDTO;
import com.zgtec.zgrmc.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UmsAdminService umsAdminService;
    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
//    public Result login(@Validated @RequestBody UmsAdminLoginDTO umsAdminLoginDTO) {
    public Result login(@RequestParam ("username") String username,@RequestParam ("password") String password) {
        UmsAdminLoginDTO umsAdminLoginDTO =new UmsAdminLoginDTO();
        return umsAdminService.login(username,password);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        UserDto userDTO = umsAdminService.loadUserByUsername(username);
        return userDTO;
    }

    @GetMapping(value = "/test1")
    @ApiOperation(value = "测试")
    public Result test1() {
        System.out.println("##################");
        return Result.success(ResultCodeEnum.SUCCESS);
    }
}
