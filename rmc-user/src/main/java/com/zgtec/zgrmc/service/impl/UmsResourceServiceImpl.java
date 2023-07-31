package com.zgtec.zgrmc.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgtec.zgrmc.constant.AuthConstant;
import com.zgtec.zgrmc.dao.UmsResourceDAO;
import com.zgtec.zgrmc.pojo.entity.UmsResourceDO;
import com.zgtec.zgrmc.pojo.param.UmsResourceParam;
import com.zgtec.zgrmc.pojo.query.UmsResourceRolesVO;
import com.zgtec.zgrmc.service.RedisService;
import com.zgtec.zgrmc.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:52 星期一
 * @Version 1.0
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceDAO,UmsResourceDO> implements UmsResourceService {
    private static final BeanCopier copier = BeanCopier.create(UmsResourceParam.class,UmsResourceDO.class,  false);
    @Autowired
    private UmsResourceDAO umsResourceDAO;
    @Autowired
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;
    @Override
    public int saveResource(UmsResourceParam umsResourceParam) {
        UmsResourceDO umsResourceDO =new UmsResourceDO();
        copier.copy(umsResourceParam,umsResourceDO,null);
        int result = umsResourceDAO.insert(umsResourceDO);
        return result;
    }

    @Override
    public int updateResource(UmsResourceParam umsResourceParam) {
        UmsResourceDO umsResourceDO =new UmsResourceDO();
        copier.copy(umsResourceParam,umsResourceDO,null);
        int result = umsResourceDAO.updateById(umsResourceDO);
        return result;
    }

    @Override
    public int deleteResource(Long id) {
        int result = umsResourceDAO.deleteById(id);
        return result;
    }

    @Override
    public  Map<String, List<String>> initResourceRolesMap() {
        //管理端路径需校验权限
        Map<String,List<String>> resourceRolesMap = new TreeMap<>();
        //获取所有资源关联角色
        List<UmsResourceRolesVO>resourceRoles = umsResourceDAO.queryResourceRoles();
        resourceRoles.stream().forEach(umsResourceRolesVO -> {
            resourceRolesMap.put("/"+applicationName + umsResourceRolesVO.getResourceName(), CollUtil.toList(umsResourceRolesVO.getRoleName()));
        });
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY,resourceRolesMap);
        return resourceRolesMap;
    }
}
