package pers.ccy.ssatweb.controller;

import org.springframework.web.bind.annotation.*;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.Article;
import pers.ccy.ssatweb.service.ArticleService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2020-07-06 04:04:43
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    @GetMapping("/list")
    public RespBean list(){
        try{
            List<Article> list = articleService.queryAll();
            return RespBean.ok("查询成功",list);
        }catch (Exception e){
            return RespBean.error("查询失败");
        }
    }

    @GetMapping("/delete/{id}")
    public RespBean delete(@PathVariable("id") Long id){
        try {
            articleService.deleteById(id);
            return RespBean.ok("删除成功");
        } catch (Exception e){
            return RespBean.error("删除失败");
        }
    }

    @PostMapping("/update")
    public RespBean update(Article article) {
        try {
            article.setDate(new Date());
            articleService.update(article);
            return RespBean.ok("更新成功");
        } catch (Exception e){
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/add")
    public RespBean add(Article article) {
        try {
            article.setDate(new Date());
            articleService.insert(article);
            return RespBean.ok("添加成功");
        } catch (Exception e){
            return RespBean.error("添加失败");
        }
    }
}