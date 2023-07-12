package com.zgtec.zgrmc.service.impl;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.constant.AuthConstant;
import com.zgtec.zgrmc.enums.ResultCodeEnum;
import com.zgtec.zgrmc.service.AuthService;
import com.zgtec.zgrmc.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zkc
 * @description
 * @Date 2023/4/7 13:16 星期五
 * @Version 1.0
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private AuthService authService;
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
}
