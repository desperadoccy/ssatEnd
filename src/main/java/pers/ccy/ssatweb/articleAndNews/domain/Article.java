package pers.ccy.ssatweb.articleAndNews.domain;

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
    Integer id;
    String title;
    String introduction;
    String url;
    Date date;
    String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", titile='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }
}
