package com.ithemia.controller;

import com.ithemia.domain.Comment;
import com.ithemia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myCommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("/select/{id}")
    public Comment findById(@PathVariable("id") Integer id){
        return commentService.findByID(id);
    }

    @ResponseBody
    @RequestMapping("/update/{id}/{author}/{content}")
    public String Update(@PathVariable("id") Integer id,@PathVariable("author") String author,
                         @PathVariable("content") String content)
    {
        Comment comment= new Comment();
        comment.setId(id);
        comment.setAuthor(author);
        comment.setContent(content);
        Comment comment1= commentService.updateComment(comment);
        return comment1.toString();
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public void Del(@PathVariable("id") Integer id)
    {
        commentService.delComment(id);
    }

    @ResponseBody
    @RequestMapping("/insert/{id}/{author}/{content}")
    public  void insertComment(@PathVariable("id") Integer id,@PathVariable("author") String author,
                               @PathVariable("content") String content)
    {
        Comment comment= new Comment();
        comment.setId(id);
        comment.setAuthor(author);
        comment.setContent(content);
        commentService.insertComment(comment);
    }

}
