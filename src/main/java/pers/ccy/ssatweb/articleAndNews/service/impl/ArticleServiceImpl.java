package pers.ccy.ssatweb.articleAndNews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.articleAndNews.common.Status;
import pers.ccy.ssatweb.articleAndNews.common.StatusCode;
import pers.ccy.ssatweb.articleAndNews.dao.ArticleDao;
import pers.ccy.ssatweb.articleAndNews.domain.Article;
import pers.ccy.ssatweb.articleAndNews.service.ArticleService;

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

    @Autowired
    private ArticleDao articleDao;

    /**
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    @Override
    public Status createArticle(Article article) {
        Article article1 = articleDao.findArticleByTitle(article.getTitle());
        Status status = new Status();
        if (article1 == null) {
            articleDao.createArticle(article);
            status.setStatusCode(StatusCode.SUCCESS);
            status.setMessage("创建成功");
        } else {
            status.setStatusCode(StatusCode.FAILED);
            status.setMessage("文章标题重名");
        }
        return status;
    }

    /**
     * @param [article]
     * @MethodName updateArticle
     * @Description
     */
    @Override
    public Status updateArticle(Article article) {
        Article article1 = articleDao.findArticleByTitle(article.getTitle());
        Status status = new Status();
        if (article1 == null || article1.getTitle().equals(article.getTitle())) {
            articleDao.updateArticle(article);
            status.setStatusCode(StatusCode.SUCCESS);
            status.setMessage("更新成功");
        } else {
            status.setStatusCode(StatusCode.FAILED);
            status.setMessage("文章标题重名");
        }
        return status;
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
        return null;
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
