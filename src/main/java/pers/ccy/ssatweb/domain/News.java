package pers.ccy.ssatweb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author desperado
 * @ClassName News
 * @Description
 * @date 2020/4/29 0:38
 * @Version 1.0
 */
public class News implements Serializable {
    private Integer id;
    private String title;
    Date date;
    String author;
    String content;

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

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
