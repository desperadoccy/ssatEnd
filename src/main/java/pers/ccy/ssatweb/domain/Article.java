package pers.ccy.ssatweb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author desperado
 * @ClassName Article
 * @Description
 * @date 2020/4/27 22:26
 * @Version 1.0
 */
public class Article implements Serializable {
    private Long id;
    private String title;
    private String introduction;
    private String url;
    private Date date;
    private String author;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
