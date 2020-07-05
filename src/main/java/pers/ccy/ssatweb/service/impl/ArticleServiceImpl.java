package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.dao.ArticleDao;
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
@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    @Override
    public RespBean createArticle(Article article) {
        Article article1 = articleDao.findArticleByTitle(article.getTitle());
        RespBean respBean;
        if (article1 == null) {
            articleDao.createArticle(article);
            respBean = RespBean.ok("创建成功");
        } else {
            respBean = RespBean.error("文章标题重名");
        }
        return respBean;
    }

    /**
     * @param [article]
     * @MethodName updateArticle
     * @Description
     */
    @Override
    public RespBean updateArticle(Article article) {
        Article article1 = articleDao.findArticleByTitle(article.getTitle());
        RespBean respBean;
        if (article1 == null || article1.getTitle().equals(article.getTitle())) {
            articleDao.updateArticle(article);
            respBean = RespBean.ok("更新成功");
        } else {
            respBean = RespBean.error("文章标题重名");
        }
        return respBean;
    }

    /**
     * @param [name]
     * @MethodName findArticleByName
     * @Description
     */
    @Override
    public Article findArticleByTitle(String title) {
        return articleDao.findArticleByTitle(title);
    }

    /**
     * @param []
     * @MethodName findAll
     * @Description
     */
    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    /**
     * @param [size, page]
     * @MethodName findArticleByPage
     * @Description
     */
    @Override
    public List<Article> findArticleByPage(int size, int page) {
        return articleDao.findArticleByPage((page - 1) * size, size);
    }
}
