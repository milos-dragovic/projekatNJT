package com.durag.dao;

 import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.durag.model.Comment;
 
/**
 * Comment DAO (Data-Access-Object) interfejs 
 * nasledjuje genericki Springov CRUD-Repository Interfejs za Comment model  
 * 
 * */

@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {

	List<Comment> findByPhotoId(Long photoId);
	Comment findOne(Long commentId);
	Comment save(Comment comment);
}
