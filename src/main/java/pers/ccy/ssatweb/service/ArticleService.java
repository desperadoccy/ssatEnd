package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.Article;

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
     * @MethodName createArticle
     * @Description
     * @param [article]
     */
    void createArticle(Article article);

    /**
     * @MethodName updateArticle
     * @Description
     * @param [article]
     */
    void updateArticle(Article article);

    /**
     * @MethodName findArticleByName
     * @Description
     * @param [name]
     */
    Article findArticleByName(String name);

    /**
     * @MethodName findAll
     * @Description
     * @param []
     */
    List<Article> findAll();
}
