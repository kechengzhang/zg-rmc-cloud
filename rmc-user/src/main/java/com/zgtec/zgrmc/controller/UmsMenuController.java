package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.param.UmsMenuParam;
import com.zgtec.zgrmc.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:44 星期一
 * @Version 1.0
 */
@RestController
@Api(tags = "UmsMenuController", description = "菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;
    @PostMapping(value = "/menus")
    @ApiOperation(value = "添加菜单")
    public Result saveUser(@RequestBody UmsMenuParam umsMenuParam) {
        int result =umsMenuService.saveMenu(umsMenuParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @PutMapping(value = "/menus/{id}")
    @ApiOperation(value = "修改菜单")
    public Result updateMenu(@PathVariable("id") Long id , @RequestBody UmsMenuParam umsMenuParam) {
        int result =umsMenuService.updateMenu(umsMenuParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @DeleteMapping(value = "/menus/{id}")
    @ApiOperation(value = "删除菜单")
    public Result deleteMenu(@PathVariable("id") Long id) {
        int result =umsMenuService.deleteMenu(id);
        if(result > 0){
            return Result.success(ResultCodeEnum.DELETE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.DELETE_ERROR);
    }
}
