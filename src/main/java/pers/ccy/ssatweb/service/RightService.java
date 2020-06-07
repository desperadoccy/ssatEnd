package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.common.RespBean;

/**
 * @author desperado
 * @ClassName RightService
 * @Description
 * @date 2020/6/7 16:13
 * @Version 1.0
 */
public interface RightService {
    public RespBean list();

    public RespBean listByTree();
}
