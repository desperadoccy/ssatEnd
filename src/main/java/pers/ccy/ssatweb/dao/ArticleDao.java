package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.ccy.ssatweb.domain.Article;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from article where title = #{title}")
    Article findArticleByTitle(String title);

    @Select("select * from article")
    List<Article> findAll();

    @Select("select * from article limit #{begin},#{num}")
    List<Article> findArticleByPage(int begin, int num);

    @Insert("insert into article (title, introduction, url, date, author) values (#{title}, #{introduction}, #{url}, #{date}, #{author})")
    void createArticle(Article article);

    @Update("update article set title=#{title} , introduction=#{introduction},url=#{url},date=#{date}, author=#{author} where id =#{id}")
    void updateArticle(Article article);
}
