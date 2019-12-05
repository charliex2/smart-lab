package cn.chingshen.smartlab.models;

import cn.chingshen.smartlab.models.acl.Role;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class User implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private Boolean isExpired;
    private Boolean isLocked;
    private Boolean isEnable;
    private List<Role> roles;

    @Override
    public List<Role> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}
