package com.github.geemu.pangu.uaa.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * ResponseWriter
 * @author 陈方明  cfmmail@sina.com
 * @since 2023-01-05 21:29
 */
@Slf4j
@Component
public class ResponseWriter {

    /**
     * write
     * @param request request
     * @param response response
     * @param objectMapper objectMapper
     * @param httStatus httStatus
     * @throws IOException IOException
     */
    public void write(HttpServletRequest request, HttpServletResponse response, ObjectMapper objectMapper, int httStatus, Object body) throws IOException {
        if (response.isCommitted()) {
            log.debug("Response has already been committed");
            return;
        }
        response.setStatus(httStatus);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String responseJson = objectMapper.writeValueAsString(body);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(responseJson);
        printWriter.flush();
        printWriter.close();
    }

}
