package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.param.UmsRoleParam;
import com.zgtec.zgrmc.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 10:03 星期一
 * @Version 1.0
 */
@RestController
@Api(tags = "UmsRoleController", description = "后台角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;
    @PostMapping(value = "/roles")
    @ApiOperation(value = "添加角色信息")
    public Result saveRole(@RequestBody UmsRoleParam umsAdminParam) {
        int result =umsRoleService.saveRole(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @PutMapping(value = "/roles")
    @ApiOperation(value = "修改角色信息")
    public Result updateRole(@RequestBody UmsRoleParam umsAdminParam) {
        int result =umsRoleService.updateRole(umsAdminParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @DeleteMapping(value = "/roles/{id}")
    @ApiOperation(value = "删除角色信息")
    public Result deleteRole(@PathVariable("id") Long id) {
        int result =umsRoleService.deleteRole(id);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
//    @PostMapping(value = "/roles")
//    @ApiOperation(value = "分配菜单")
//    public Result deleteRole(@PathVariable("id") Long id) {
//        int result =umsRoleService.deleteRole(id);
//        if(result > 0){
//            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
//        }
//        return Result.failure(ResultCodeEnum.SAVE_ERROR);
//    }

}
