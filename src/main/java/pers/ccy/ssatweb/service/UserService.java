package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.vo.UsersVO;

import java.util.List;

/**
 * @author desperado
 * @ClassName UserService
 * @Description
 * @date 2020/5/2 21:43
 * @Version 1.0
 */
public interface UserService {

    /**
     * @MethodName loadUserByUsername
     * @Description
     * @param [name]
     */
    public UserInfo findUserByUsername(String name);

    public RespBean addUser(UserInfo userInfo);

    public RespBean findAll(int num, int size);

    public RespBean updateStatus(int userId, int status);
}
