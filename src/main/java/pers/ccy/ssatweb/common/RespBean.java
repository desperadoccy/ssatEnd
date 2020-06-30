package pers.ccy.ssatweb.common;

/**
 * @author desperado
 * @ClassName RespBean
 * @Description
 * @date 2020/5/3 2:00
 * @Version 1.0
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;
    private String jwtToken;

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null, null);
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj, null);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj, null);
    }

    public static RespBean custom(Integer status, String msg) {
        return new RespBean(status, msg, null, null);
    }

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object obj, String jwtToken) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
        this.jwtToken = jwtToken;
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
