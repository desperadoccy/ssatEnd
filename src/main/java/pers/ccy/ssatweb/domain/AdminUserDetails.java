package pers.ccy.ssatweb.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author desperado
 * @ClassName AdminUserDetails
 * @Description
 * @date 2020/7/2 16:30
 * @Version 1.0
 */
public class AdminUserDetails implements UserDetails {
    private SsatAdmin ssatAdmin;
    private List<SsatResource> resourceList;
    public AdminUserDetails(SsatAdmin ssatAdmin,List<SsatResource> resourceList) {
        this.ssatAdmin = ssatAdmin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return ssatAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return ssatAdmin.getUsername();
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

    @Override
    public boolean isEnabled() {
        return ssatAdmin.getActive().equals(1);
    }
}
