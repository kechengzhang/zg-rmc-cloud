package com.zgtec.zgrmc.controller;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.param.UmsResourceParam;
import com.zgtec.zgrmc.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:49 星期一
 * @Version 1.0
 */
@RestController
@Api(tags = "UmsResourceController", description = "资源管理")
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService umsResourceService;
    @PostMapping(value = "/resources")
    @ApiOperation(value = "添加资源信息")
    public Result saveResource(@RequestBody UmsResourceParam umsResourceParam) {
        int result =umsResourceService.saveResource(umsResourceParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @PutMapping(value = "/resources")
    @ApiOperation(value = "修改资源信息")
    public Result updateResource(@RequestBody UmsResourceParam umsResourceParam) {
        int result =umsResourceService.updateResource(umsResourceParam);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @DeleteMapping(value = "/resources/{id}")
    @ApiOperation(value = "删除角色信息")
    public Result deleteResource(@PathVariable("id") Long id) {
        int result =umsResourceService.deleteResource(id);
        if(result > 0){
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        }
        return Result.failure(ResultCodeEnum.SAVE_ERROR);
    }
    @GetMapping(value = "/initResourceRolesMap")
    @ApiOperation(value = "初始化资源角色关联数据")
    public Result initResourceRolesMap() {
        umsResourceService.initResourceRolesMap();
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

}
