package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.dao.UmsAdminDAO;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.pojo.param.UmsAdminRoleRelationParam;
import com.zgtec.zgrmc.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/login")
    public Result login(@RequestParam ("username") String username,@RequestParam ("password") String password) {
        return umsAdminService.login(username,password);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping(value = "/users/{userName}")
    @ResponseBody
    public UserDto loadUserByUsername(@PathVariable("userName") String userName) {
        UserDto userDTO = umsAdminService.loadUserByUsername(userName);
        return userDTO;
    }

    @PostMapping(value = "/users")
    @ApiOperation(value = "添加用户信息")
    public Result saveUser(@RequestBody UmsAdminParam umsAdminParam) {
        int result =umsAdminService.saveUser(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @PutMapping(value = "/users/{id}")
    @ApiOperation(value = "修改用户信息")
    public Result updateUser(@PathVariable("id") Long id ,@RequestBody UmsAdminParam umsAdminParam) {
        int result =umsAdminService.updateUser(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @DeleteMapping(value = "/users/{id}")
    @ApiOperation(value = "删除用户")
    public Result deleteUser(@PathVariable("id") Long id) {
        int result =umsAdminService.deleteUser(id);
        if(result > 0){
            return Result.success(ResultCodeEnum.DELETE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.DELETE_ERROR);
    }
    @DeleteMapping(value = "/users")
    @ApiOperation(value = "分配角色")
    public Result saveAdminRoleRelation(@RequestBody List<UmsAdminRoleRelationParam>list) {
        int result =umsAdminService.saveAdminRoleRelation(list);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }

}
