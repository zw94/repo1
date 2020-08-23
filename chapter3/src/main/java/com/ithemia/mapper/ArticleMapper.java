package com.ithemia.mapper;

import com.ithemia.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

//使用配置文件xml的方式整合mybatis
@Component
@Mapper
public interface ArticleMapper {
    public Article selectArticle(Integer id);

    public  int upArticle(Article article);

    public int insertArticle(Article article);

    public int deleteArticle(int id);
}
