//package com.github.geemu.pangu.backend.service.impl;
//
//import com.github.geemu.core.exception.BizRuntimeException;
//import com.github.geemu.pangu.backend.domain.entity.UserEntity;
//import com.github.geemu.pangu.backend.mapper.SysUserMapper;
//import com.github.geemu.pangu.backend.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//import static com.github.geemu.core.domain.DefaultResponseState.SERVER_ERROR;
//
///**
// * UserService
// * @author 陈方明  cfmmail@sina.com
// * @since 2021-11-07 12:41
// */
//@Service
//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
//public class UserServiceImpl implements UserService {
//
//    private final SysUserMapper userMapper;
//
//    @Override
//    public long add(UserEntity entity) {
//        // 校验对应工号用户是否已经存在
//        boolean exist = userMapper.existByEmpNo(entity.getEmpNo());
//        if (exist) {
//            throw new BizRuntimeException(SERVER_ERROR);
//        }
//        LocalDateTime now = LocalDateTime.now();
//        entity.setCreatedAt(now);
//        String defaultUser = "system";
//        entity.setCreatedBy("system");
//        entity.setUpdatedAt(now);
//        entity.setUpdatedBy(defaultUser);
//        entity.setDeleted(Boolean.FALSE);
//        entity.setVersion(0L);
//        entity.setEnabled(Boolean.TRUE);
//        long rows = userMapper.insertSelective(entity);
//        if (rows <= 0) {
//            throw new BizRuntimeException(SERVER_ERROR);
//        }
//        return entity.getId();
//    }
//
//}
