package com.github.geemu.pangu.uaa.config.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.geemu.pangu.uaa.config.ResponseWriter;
import com.github.geemu.pangu.uaa.core.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.github.geemu.pangu.uaa.core.http.DefaultResponseState.FORBIDDEN;
import static com.github.geemu.pangu.uaa.core.http.DefaultResponseState.UN_AUTHORIZED;


/**
 * 处理鉴权失败
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-03-26 22:27
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AccessDeniedHandle extends ResponseWriter implements AuthenticationEntryPoint, AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    /**
     * 未登录用户拒绝访问受保护资源
     * @param request request
     * @param response response
     * @param exception exception
     * @throws IOException IOException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        super.write(request, response, objectMapper, HttpServletResponse.SC_UNAUTHORIZED, new ResponseEntity<>(UN_AUTHORIZED));
    }

    /**
     * 认证用户拒绝访问无权限资源
     * @param request request
     * @param response response
     * @param exception exception
     * @throws IOException IOException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException {
        super.write(request, response, objectMapper, HttpServletResponse.SC_FORBIDDEN, new ResponseEntity<>(FORBIDDEN));

    }

}
