package com.github.geemu.pangu.common.mapper;

import com.github.geemu.pangu.common.entity.BaseVersionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 基础乐观锁实体数据库操作
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-05-09 21:48
 */
@Mapper
@Repository
public interface BaseVersionMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<BaseVersionEntity> {

}
