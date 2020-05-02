package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.dao.UserDao;
import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desperado
 * @ClassName UserServiceImpl
 * @Description
 * @date 2020/5/2 21:43
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo findUserByUsername(String name) {
        return userDao.findUserByUsername(name);
    }
}
