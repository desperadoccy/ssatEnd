package pers.ccy.ssatweb.common;

/**
 * @author desperado
 * @ClassName StatusCode
 * @Description
 * @date 2020/4/27 22:40
 * @Version 1.0
 */
public enum  StatusCode {
    SUCCESS("success"),
    WAIT("wait"),
    FAILED("failed");

    private String status;
    StatusCode(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
