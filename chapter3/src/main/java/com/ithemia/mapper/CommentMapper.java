package com.ithemia.mapper;

import com.ithemia.domain.Comment;
import org.apache.ibatis.annotations.*;

//使用注解的方式整合mybatis
@Mapper
public interface CommentMapper {
    @Select("select * from t_comment where id=#{id}")
    public Comment findById(Integer id);

    @Insert("insert into t_comment(content,author,a_id) values(#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    @Update("UPDATE t_comment SET author= #{author},content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    @Delete("delete from t_comment where id=#{id}")
    public int deleteComment(Integer id);
}
