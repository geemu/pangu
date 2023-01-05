package com.github.geemu.pangu.uaa.mapper;

import com.github.geemu.pangu.uaa.domain.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户实体数据库操作
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-05-09 21:48
 */
@Mapper
@Repository
public interface SysUserMapper {

    /**
     * 根据id查询
     * @param id id
     * @return UserEntity
     */
    SysUserEntity selectById(@Param("id") Long id);

    /**
     * insertSelective
     * @param user user
     * @return int
     */
    int insertSelective(@Param("user") SysUserEntity user);

}
