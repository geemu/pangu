package com.github.geemu.pangu.backend.app.mapper;

import com.github.geemu.pangu.backend.app.entity.BackendUserEntity2;
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
public interface BackendUserMapper2 {

    BackendUserEntity2 selectById2(@Param("id") Long id);

}
