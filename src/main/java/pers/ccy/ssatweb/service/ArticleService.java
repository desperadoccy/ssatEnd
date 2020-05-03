package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.common.RespBean;
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
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    RespBean createArticle(Article article);

    /**
     * @param [article]
     * @MethodName updateArticle
     * @Description
     */
    RespBean updateArticle(Article article);

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
