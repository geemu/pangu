package com.github.geemu.pangu.backend.mapper;

import com.github.geemu.pangu.backend.entity.BackendUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户实体数据库操作
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-05-09 21:48
 */
@Mapper
public interface BackendUserMapper {

    BackendUserEntity selectById(@Param("id") Long id);

}
