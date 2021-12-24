package com.github.geemu.pangu.backend.config.security;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * CustomUserDetails
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-01-01 14:58
 */
public class CustomUserDetails implements UserDetails, CredentialsContainer {

    /** 用户id **/
    private Long id;
    /** 用户名  忽略大小写 **/
    private String username;
    /** 密码  区分大小写 **/
    private String password;
    /** 是否可用  0不可用  1可用 **/
    private Boolean enabled;
    /** 角色id集合 **/
    private Set<GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public CustomUserDetails(Long id, String username, String password, Boolean enabled, Set<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

}
