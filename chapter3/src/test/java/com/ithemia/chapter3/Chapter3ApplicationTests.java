
package com.ithemia.chapter3;

import com.ithemia.domain.Article;
import com.ithemia.domain.Comment;
import com.ithemia.mapper.ArticleMapper;
import com.ithemia.mapper.CommentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter3ApplicationTests {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleMapper articleMapper;


   @Test
    public void selectComment() {
       Comment comment=commentMapper.findById(5);
       System.out.println(comment);
    }

    @Test
    public void selectArticle() {
        Article article=articleMapper.selectArticle(2);
        System.out.println(article);
    }

    @Test
    public void insertArticle(){
        Article article = new Article();
        article.setId(15);
        article.setContent("niu!!!");
        article.setTitle("我叫鲁志威！");
        int i=articleMapper.insertArticle(article);
    }

}

