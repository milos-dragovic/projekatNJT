package com.durag.service;



import java.util.List;

import com.durag.model.Comment;

/**
 * CommentService interfejs
 * */
public interface CommentService {
   
	Comment findOne(Long commentId);
    List<Comment> findByPhotoId (Long photoId);
    Comment save(Comment comment);

}
