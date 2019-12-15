package com.durag.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durag.dao.CommentDao;
import com.durag.model.Comment;
import com.durag.service.CommentService;

/**
 * ComentService impementacija CommentService interfejsa
 * pristup bazi pomocu Comment-DAO
 * 
 * */

@Service
public class CommentServiceImpl implements CommentService {

	/** CommentDAO instanca*/
    @Autowired
    private CommentDao commentDao;

    public Comment findOne (Long commentId) {
        return commentDao.findOne(commentId);  //vraca komentar po id
    }
    public List<Comment> findByPhotoId (Long photoId) {
        return commentDao.findByPhotoId(photoId); // vraca listu komentara za odredjenu sliku
    }
    public Comment save(Comment comment) {
        return commentDao.save(comment);  //Cuva u bazi komentar
    }

}
