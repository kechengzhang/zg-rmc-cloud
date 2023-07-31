package com.zgtec.zgrmc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgtec.zgrmc.dao.UmsMenuDAO;
import com.zgtec.zgrmc.pojo.entity.UmsAdminDO;
import com.zgtec.zgrmc.pojo.entity.UmsMenuDO;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.pojo.param.UmsMenuParam;
import com.zgtec.zgrmc.service.UmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:44 星期一
 * @Version 1.0
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuDAO,UmsMenuDO> implements UmsMenuService {
    private static final BeanCopier copier = BeanCopier.create(UmsMenuParam.class,UmsMenuDO.class,  false);
    @Autowired
    private UmsMenuDAO umsMenuDAO;
    @Override
    public int saveMenu(UmsMenuParam umsMenuParam) {
        UmsMenuDO umsMenuDO = new UmsMenuDO();
        copier.copy(umsMenuParam,umsMenuDO,null);
        int result = umsMenuDAO.insert(umsMenuDO);
        return result;
    }

    @Override
    public int updateMenu(UmsMenuParam umsMenuParam) {
        UmsMenuDO umsMenuDO = new UmsMenuDO();
        copier.copy(umsMenuParam,umsMenuDO,null);
        int result = umsMenuDAO.updateById(umsMenuDO);
        return result;
    }

    @Override
    public int deleteMenu(Long id) {
        int result = umsMenuDAO.deleteById(id);
        return result;
    }
}
