package pers.ccy.ssatweb.articleAndNews.common;

/**
 * @author desperado
 * @ClassName Status
 * @Description Response status
 * @date 2020/4/27 22:34
 * @Version 1.0
 */
public class Status {

    StatusCode statusCode;
    String message;

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}
