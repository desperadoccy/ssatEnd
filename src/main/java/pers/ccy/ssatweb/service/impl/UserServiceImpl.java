package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.dao.UserDao;
import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.service.UserService;
import pers.ccy.ssatweb.vo.UserVO;
import pers.ccy.ssatweb.vo.UsersVO;

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

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserInfo findUserByUsername(String name) {
        return userDao.findUserByUsername(name);
    }

    @Override
    public RespBean addUser(UserInfo userInfo) {
        try {
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            userDao.addUser(userInfo);
            return RespBean.ok("添加成功");
        } catch (Exception e) {
            return RespBean.error("用户重名");
        }
    }

    @Override
    public RespBean findUser(int num, int size, String query) {
        try {
            List<UserInfo> infos = userDao.findUser((num - 1) * size, size, query);
            int countAll = userDao.countAll(query);
            List<UserVO> userVOS = UserVO.parseBy(infos);
            UsersVO usersVO = new UsersVO();
            usersVO.setUsers(userVOS);
            usersVO.setCount(countAll);
            return RespBean.ok("查询成功", usersVO);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @Override
    public RespBean updateStatus(int userId, int status) {
        //设置不可更改白名单
//        if (userDao.findUserInWhiteList(userId) != null) {
//            return RespBean.error("该用户为超级管理员，无法改变状态");
//        }
//        LoginUser loginUser = userLoginService.getLoginUser();
//        if (loginUser.getId() == userId)
//            return RespBean.error("不能改变自己的状态");
//        try {
//            userDao.updateUserStatus(userId, status);
//            return RespBean.ok("更新成功");
//        } catch (Exception e) {
//            return RespBean.error("更新失败");
//        }
        return null;
    }

    @Override
    public RespBean findUserById(int id) {
        try {
            UserInfo user = userDao.findUserById(id);
            UserVO userVO = UserVO.parseBy(user);
            return RespBean.ok("查询成功", userVO);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @Override
    public RespBean updateUser(UserInfo userInfo) {
        try {
            userDao.updateUser(userInfo);
            return RespBean.ok("更新成功");
        } catch (Exception e) {
            return RespBean.error("更新失败");
        }
    }

    @Override
    public RespBean deleteUser(int id) {
//        //设置不可更改白名单
//        if (userDao.findUserInWhiteList(id) != null) {
//            return RespBean.error("该用户为超级管理员，无法删除");
//        }
//        LoginUser loginUser = userLoginService.getLoginUser();
//        if (loginUser.getId() == id)
//            return RespBean.error("不能删除自己");
//        try {
//            userDao.deleteUser(id);
//            return RespBean.ok("删除成功");
//        } catch (Exception e) {
//            return RespBean.error("删除失败");
//        }
        return null;
    }


}
