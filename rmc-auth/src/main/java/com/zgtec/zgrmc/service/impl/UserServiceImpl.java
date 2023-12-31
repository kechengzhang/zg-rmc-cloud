package com.zgtec.zgrmc.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.zgtec.zgrmc.constant.AuthConstant;
import com.zgtec.zgrmc.constant.MessageConstant;
import com.zgtec.zgrmc.domain.SecurityUser;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
/**
 * @author  zkc
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private HttpServletRequest request;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto = new UserDto();
//        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)) {
            userDto = adminService.loadUserByUsername(username);
//            System.out.println("@@@@@@@@@@@"+userDto.getRoles());
//            userDto.setId(1L);
//            userDto.setUsername("zkc");
//            userDto.setRoles(CollUtil.toList("ADMIN"));
//            //密码需要 BCrypt.hashpw("123456")
//            userDto.setPassword(BCrypt.hashpw(userDto.getPassword()));
//            userDto.setPassword(BCrypt.hashpw("123456"));
//            userDto.setStatus(1);
            userDto.setClientId(AuthConstant.ADMIN_CLIENT_ID);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$gagaga");
//        }
        if (userDto==null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
