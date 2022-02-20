package com.github.geemu.pangu.backend.mapper;

import com.github.geemu.pangu.backend.entity.UserEntity;
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
public interface UserMapper {

    /**
     * 根据id查询
     * @param id id
     * @return UserEntity
     */
    UserEntity selectById(@Param("id") Long id);

    /**
     * existByEmpNo
     * @param empNo empNo
     * @return boolean
     */
    boolean existByEmpNo(@Param("empNo") String empNo);

    /**
     * insertSelective
     * @param entity entity
     * @return int
     */
    int insertSelective(@Param("entity") UserEntity entity);

}
