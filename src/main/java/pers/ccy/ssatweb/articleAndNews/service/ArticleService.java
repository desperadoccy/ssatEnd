package pers.ccy.ssatweb.articleAndNews.service;

import pers.ccy.ssatweb.articleAndNews.common.Status;
import pers.ccy.ssatweb.articleAndNews.domain.Article;

import java.util.List;

/**
 * @author desperado
 * @ClassName ArticleService
 * @Description
 * @date 2020/4/27 22:29
 * @Version 1.0
 */
public interface ArticleService {
    /**
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    Status createArticle(Article article);

    /**
     * @param [article]
     * @MethodName updateArticle
     * @Description
     */
    Status updateArticle(Article article);

    /**
     * @param [name]
     * @MethodName findArticleByName
     * @Description
     */
    Article findArticleByTitle(String title);

    /**
     * @param []
     * @MethodName findAll
     * @Description
     */
    List<Article> findAll();

    /**
     * @param [size, page]
     * @MethodName findArticleByPage
     * @Description
     */
    List<Article> findArticleByPage(int size, int page);
}
