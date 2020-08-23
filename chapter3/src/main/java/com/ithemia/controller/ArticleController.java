package com.ithemia.controller;

import com.ithemia.domain.Article;
import com.ithemia.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //窄化请求路劲
public class ArticleController {

    //注入service
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/get/{id}")
    public Article findById(@PathVariable("id") int article_id){
        return articleService.findById(article_id);
    }
}
