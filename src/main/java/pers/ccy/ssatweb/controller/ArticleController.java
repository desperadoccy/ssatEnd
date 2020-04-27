package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.Status;
import pers.ccy.ssatweb.common.StatusCode;
import pers.ccy.ssatweb.domain.Article;
import pers.ccy.ssatweb.service.ArticleService;
import pers.ccy.ssatweb.service.impl.ArticleServiceImpl;

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
    @RequestMapping("/create")
    public Status createArticle(Article article) {
        Status status = new Status();
        try {
            articleService.createArticle(article);
            status.setStatusCode(StatusCode.SUCCESS);
            status.setMessage("上传成功");
        } catch (Exception e) {
            status.setStatusCode(StatusCode.FAILED);
            status.setMessage("上传失败");
        }

        return status;
    }

    /**
     * @MethodName updateArticle
     * @Description
     * @param [article]
     */
    @RequestMapping("/update")
    public Status updateArticle(Article article) {
        Status status = new Status();
        try {
            articleService.updateArticle(article);
            status.setStatusCode(StatusCode.SUCCESS);
            status.setMessage("更新成功");
        } catch (Exception e) {
            status.setStatusCode(StatusCode.FAILED);
            status.setMessage("更新失败");
        }

        return status;
    }

    @RequestMapping("/findByName")
    public Article findArticleByName(String name){
        return articleService.findArticleByName(name);
    }

    @RequestMapping("/findAll")
    public List<Article> findAll(){
        return articleService.findAll();
    }
}
