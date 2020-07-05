package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.Article;
import pers.ccy.ssatweb.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    @PostMapping("/create")
    public RespBean createArticle(Article article) {
        return articleService.createArticle(article);
    }

    /**
     * @param [article]
     * @MethodName updateArticle
     * @Description
     */
    @PostMapping("/update")
    public RespBean updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @RequestMapping("/findByTitle")
    public Article findArticleByTitle(String title) {
        return articleService.findArticleByTitle(title);
    }

    @RequestMapping("/findAll")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @RequestMapping("/findByPage")
    public List<Article> findByPage(int size, int page) {
        return articleService.findArticleByPage(size, page);
    }
}
