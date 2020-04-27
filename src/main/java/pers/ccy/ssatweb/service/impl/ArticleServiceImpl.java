package pers.ccy.ssatweb.service.impl;

import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.domain.Article;
import pers.ccy.ssatweb.service.ArticleService;

import java.util.List;

/**
 * @author desperado
 * @ClassName ArticleServiceImpl
 * @Description
 * @date 2020/4/27 22:29
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * @MethodName createArticle
     * @Description
     * @param [article]
     */
    @Override
    public void createArticle(Article article) {

    }

    /**
     * @MethodName updateArticle
     * @Description
     * @param [article]
     */
    @Override
    public void updateArticle(Article article) {

    }

    /**
     * @MethodName findArticleByName
     * @Description
     * @param [name]
     */
    @Override
    public Article findArticleByName(String name) {
        Article article = new Article();
        article.setAuthor("desperado");
        article.setIntroduction("这是一次测试");
        return article;
    }

    /**
     * @MethodName findAll
     * @Description
     * @param []
     */
    @Override
    public List<Article> findAll() {
        return null;
    }
}
