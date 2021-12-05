//package com.github.geemu.pangu.backend.config.security;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.geemu.pangu.backend.core.http.ResponseEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * 处理鉴权失败
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-03-26 22:27
// */
//@Slf4j
//@Component
//public class CustomDeniedHandle implements AuthenticationEntryPoint, AccessDeniedHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * 未登录用户拒绝访问受保护资源
//     * @param httpReq HttpServletRequest
//     * @param httpResp HttpServletResponse
//     * @param e AuthenticationException
//     * @throws IOException IOException
//     */
//    @Override
//    public void commence(HttpServletRequest httpReq, HttpServletResponse httpResp, AuthenticationException e) throws IOException {
//        httpResp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        httpResp.getWriter().print(objectMapper.writeValueAsString(new ResponseEntity<>(ACCESS_ANNO_EXCEPTION)));
//        httpResp.getWriter().flush();
//        httpResp.getWriter().close();
//    }
//
//    /**
//     * 认证用户拒绝访问无权限资源
//     * @param httpReq HttpServletRequest
//     * @param httpResp HttpServletResponse
//     * @param e AccessDeniedException
//     * @throws IOException IOException
//     */
//    @Override
//    public void handle(HttpServletRequest httpReq, HttpServletResponse httpResp, AccessDeniedException e) throws IOException {
//        httpResp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        httpResp.getWriter().print(objectMapper.writeValueAsString(new ResponseEntity<>(ACCESS_AUTH_EXCEPTION)));
//        httpResp.getWriter().flush();
//        httpResp.getWriter().close();
//    }
//}
