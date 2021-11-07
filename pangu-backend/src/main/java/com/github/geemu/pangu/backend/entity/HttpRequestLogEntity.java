package com.github.geemu.pangu.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * com.github.geemu.pangu.backend.entity
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-11-07 16:35
 */
@Data
public class HttpRequestLogEntity {

    private Long id;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean deleted;
    private Long version;
    private Boolean enabled;

    private Date requestTime;
    private Date acceptTime;
    private Date responseTime;

    private String requestThreadName;
    private String responseThreadName;

}
