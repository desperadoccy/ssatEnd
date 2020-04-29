package pers.ccy.ssatweb.articleAndNews.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.ccy.ssatweb.articleAndNews.domain.Article;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from Article where title = #{title}")
    Article findArticleByTitle(String title);

    @Select("select * from Article")
    List<Article> findAll();

    @Select("select * from Article limit #{begin},#{num}")
    List<Article> findArticleByPage(int begin, int num);

    @Insert("insert into Article (title, introduction, url, date, author) values (#{title}, #{introduction}, #{url}, #{date}, #{author})")
    void createArticle(Article article);

    @Update("update Article set title=#{title} , introduction=#{introduction},url=#{url},date=#{date}, author=#{author} where id =#{id}")
    void updateArticle(Article article);
}
