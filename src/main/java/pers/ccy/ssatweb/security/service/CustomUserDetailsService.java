package pers.ccy.ssatweb.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.dao.RightDao;
import pers.ccy.ssatweb.domain.Right;
import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desperado
 * @ClassName CustomUserDetailsService
 * @Description
 * @date 2020/5/2 22:07
 * @Version 1.0
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RightDao rightDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param [s]
     * @MethodName loadUserByUsername
     * @Description
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userService.findUserByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("无此用户");
        }
        List<Right> rightList = rightDao.findByAdminUserId(userInfo.getId());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Integer id = userInfo.getId();
        authorities.add(new SimpleGrantedAuthority(id.toString()));
        for (Right right : rightList) {
            if (right != null && right.getName() != null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(right.getName());
                authorities.add(grantedAuthority);
            }
        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + userInfo.getRole().name()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), authorities);
        return user;
    }
}
