package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.dao.RightDao;
import pers.ccy.ssatweb.domain.Right;
import pers.ccy.ssatweb.service.RightService;
import pers.ccy.ssatweb.utils.TreeUtil;
import pers.ccy.ssatweb.vo.RightVO;

import java.util.List;

/**
 * @author desperado
 * @ClassName RightServiceImpl
 * @Description
 * @date 2020/6/7 16:13
 * @Version 1.0
 */
@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private RightDao rightDao;

    @Override
    public RespBean list() {
        try {
            List<Right> list = rightDao.list();
            List<RightVO> rightVOS = RightVO.parseBy(list);
            return RespBean.ok("查询成功", rightVOS);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @Override
    public RespBean listByTree() {
        try {
            List<Right> list = rightDao.list();
            List<RightVO> rightVOS = RightVO.parseBy(list);
            List<RightVO> tree = TreeUtil.toTree(rightVOS);
            return RespBean.ok("查询成功", tree);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }


}
