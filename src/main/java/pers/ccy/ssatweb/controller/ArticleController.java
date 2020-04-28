package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.Status;
import pers.ccy.ssatweb.common.StatusCode;
import pers.ccy.ssatweb.domain.Article;
import pers.ccy.ssatweb.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /**
     * @param [article]
     * @MethodName createArticle
     * @Description
     */
    @PostMapping("/create")
    public Status createArticle(Article article) {
        return articleService.createArticle(article);
    }

    /**
     * @MethodName updateArticle
     * @Description
     * @param [article]
     */
    @PostMapping("/update")
    public Status updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @RequestMapping("/findByTitle")
    public Article findArticleByTitle(String title){
        return articleService.findArticleByTitle(title);
    }

    @PostMapping("/findAll")
    public List<Article> findAll(){
        return articleService.findAll();
    }

    @RequestMapping("/findByPage")
    public List<Article> findByPage(int size, int page) { return articleService.findArticleByPage(size, page);}
}
