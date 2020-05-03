package pers.ccy.ssatweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.dao.UserDao;
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
    private PasswordEncoder passwordEncoder;
    /**
     * @MethodName loadUserByUsername
     * @Description
     * @param [s]
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println(username);
        UserInfo userInfo = userService.findUserByUsername(username);
        if (userInfo == null){
            throw new UsernameNotFoundException("not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userInfo.getRole().name()));
        User user = new User(userInfo.getUsername(),passwordEncoder.encode(userInfo.getPassword()),authorities);
        return user;
    }
}
