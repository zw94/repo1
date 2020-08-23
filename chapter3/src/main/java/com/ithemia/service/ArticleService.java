package com.ithemia.service;

import com.ithemia.domain.Article;
import com.ithemia.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ArticleService {
    /*基于api的实现方式*/
    /*先注入mapper与redisTemplate*/
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public Article findById(int article_id){
        //先从redis缓存中查询数据
        Object object= redisTemplate.opsForValue().get("commnet_hhh"+article_id);
        if(object!=null)
            return (Article)object;
        else {
            //
            Article comment = articleMapper.selectArticle(article_id);
            if (comment!=null) {
                redisTemplate.opsForValue().set("comment_" + article_id, comment,
                        1, TimeUnit.DAYS);
                return comment;
            }
            else
            {
                return  null;
            }
        }

    }
}
