package com.ithemia.service;

import com.ithemia.domain.Comment;
import com.ithemia.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    /*注入CommentMapper*/
   @Autowired
   private CommentMapper commentMapper;

    @Cacheable(cacheNames = "comment--")
    public Comment findByID(Integer comment_id){
        Comment comment = commentMapper.findById(comment_id);
        System.out.println("查询"+comment_id+"员工");
        return comment;
    };

    @CachePut(cacheNames = "comment--", key = "#result.id")
    public Comment updateComment(Comment comment)
    {
        commentMapper.updateComment(comment);
        System.out.println("---------更改数据成功--------");
        return comment;
    }

    @CacheEvict(cacheNames = "comment--")
    public void delComment(int comment_id)
    {
        commentMapper.deleteComment(comment_id);
        System.out.println("---------删除数据成功--------");
    }

    @Cacheable(cacheNames = "comment--")
    public int insertComment(Comment comment)
    {
        System.out.println("---------插入数据成功--------");
        return commentMapper.insertComment(comment);
    }
}
