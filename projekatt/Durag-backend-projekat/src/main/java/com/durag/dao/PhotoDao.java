package com.durag.dao;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.durag.model.Photo;
import com.durag.model.User;

import java.util.List;
 
/**
 * Photo DAO (Data-Access-Object) interfejs 
 * nasledjuje genericki Springov CRUD-Repository Interfejs za Photo model  
 * 
 * */

@Repository
public interface PhotoDao extends CrudRepository<Photo, Long> {
    
    List<Photo> findByUser(User user);
    Photo findByPhotoId(Long photoId);
    List<Photo> findAll();
    Photo save(Photo photo);
}
