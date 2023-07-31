package com.zgtec.zgrmc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgtec.zgrmc.dao.UmsAdminDAO;
import com.zgtec.zgrmc.dao.UmsRoleDAO;
import com.zgtec.zgrmc.pojo.entity.UmsRoleDO;
import com.zgtec.zgrmc.pojo.param.UmsRoleParam;
import com.zgtec.zgrmc.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 10:05 星期一
 * @Version 1.0
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleDAO, UmsRoleDO> implements UmsRoleService {
    private static final BeanCopier copier = BeanCopier.create(UmsRoleParam.class,UmsRoleDO.class,  false);
    @Autowired
    private UmsRoleDAO umsRoleDAO;
    @Override
    public int saveRole(UmsRoleParam umsRoleParam) {
        UmsRoleDO umsRoleDO =new UmsRoleDO();
        copier.copy(umsRoleParam,umsRoleDO,null);
        int result = umsRoleDAO.insert(umsRoleDO);
        return result;
    }

    @Override
    public int updateRole(UmsRoleParam umsRoleParam) {
        UmsRoleDO umsRoleDO =new UmsRoleDO();
        copier.copy(umsRoleParam,umsRoleDO,null);
        int result = umsRoleDAO.updateById(umsRoleDO);
        return result;
    }

    @Override
    public int deleteRole(Long id) {
        int result = umsRoleDAO.deleteById(id);
        return result;
    }
}
