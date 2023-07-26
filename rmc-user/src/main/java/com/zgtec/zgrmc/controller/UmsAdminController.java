package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.dao.UmsAdminDAO;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.dto.UmsAdminLoginDTO;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UmsAdminDAO umsAdminDAO;

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
//    public Result login(@Validated @RequestBody UmsAdminLoginDTO umsAdminLoginDTO) {
    public Result login(@RequestParam ("username") String username,@RequestParam ("password") String password) {
        UmsAdminLoginDTO umsAdminLoginDTO =new UmsAdminLoginDTO();
        umsAdminDAO.queryUserDetail("admin");
        return umsAdminService.login(username,password);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        UserDto userDTO = umsAdminService.loadUserByUsername(username);
        return userDTO;
    }

    @PostMapping(value = "/saveUser")
    @ApiOperation(value = "添加用户")
    public Result saveUser(@RequestBody UmsAdminParam umsAdminParam) {
        int result =umsAdminService.saveUser(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @PutMapping(value = "/updateUser")
    @ApiOperation(value = "添加用户")
    public Result updateUser(@RequestBody UmsAdminParam umsAdminParam) {
        int result =umsAdminService.updateUser(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }

}
