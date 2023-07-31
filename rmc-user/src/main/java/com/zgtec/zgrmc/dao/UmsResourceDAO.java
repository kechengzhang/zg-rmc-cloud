package com.zgtec.zgrmc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgtec.zgrmc.pojo.entity.UmsResourceDO;
import com.zgtec.zgrmc.pojo.query.UmsResourceRolesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:52 星期一
 * @Version 1.0
 */
@Mapper
public interface UmsResourceDAO extends BaseMapper<UmsResourceDO> {
    /**
     * 获取资源信息和角色信息
     *
     * @return
     */
    List<UmsResourceRolesVO> queryResourceRoles();
}
