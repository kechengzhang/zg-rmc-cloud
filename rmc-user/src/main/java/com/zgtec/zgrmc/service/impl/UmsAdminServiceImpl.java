package com.zgtec.zgrmc.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.constant.AuthConstant;
import com.zgtec.zgrmc.dao.UmsAdminDAO;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.pojo.dto.RoleDTO;
import com.zgtec.zgrmc.pojo.entity.UmsAdminDO;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.service.AuthService;
import com.zgtec.zgrmc.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zkc
 * @description
 * @Date 2023/4/7 13:16 星期五
 * @Version 1.0
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminDAO, UmsAdminDO> implements UmsAdminService {
    private static final BeanCopier copier = BeanCopier.create(UmsAdminParam.class, UmsAdminDO.class, false);
    @Autowired
    private AuthService authService;
    @Autowired
    private UmsAdminDAO umsAdminDAO;
    @Override
    public Result login(String userName, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",userName);
        params.put("password",password);
        Result restResult = authService.getAccessToken(params);
        if(ResultCodeEnum.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
//            updateLoginTimeByUsername(username);
            //插入日志
//            insertLoginLog(username);
        }
        return restResult;
    }

    @Override
    public UserDto loadUserByUsername(String userName) {
        UserDto userDto =new UserDto();
        userDto = umsAdminDAO.queryUserDetail(userName);
        List<RoleDTO> roleList = umsAdminDAO.loadUserByUsername(userName);
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            userDto.setRoles(roleStrList);
        }
        return userDto;
    }

    @Override
    public int saveUser(UmsAdminParam umsAdminParam) {
        UmsAdminDO umsAdminDO = new UmsAdminDO();
        copier.copy(umsAdminParam, umsAdminDO, null);
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdminParam.getPassword());
        umsAdminDO.setPassword(encodePassword);
        int result = umsAdminDAO.insert(umsAdminDO);
        return result;
    }

    @Override
    public int updateUser(UmsAdminParam umsAdminParam) {
        UmsAdminDO umsAdminDO = new UmsAdminDO();
        copier.copy(umsAdminParam, umsAdminDO, null);
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdminParam.getPassword());
        umsAdminDO.setPassword(encodePassword);
        int result = umsAdminDAO.updateById(umsAdminDO);
        return result;
    }
}
