package com.durag.service;

 

import java.util.List;

import com.durag.model.Photo;
import com.durag.model.User;
 

/**
 * PhotoService Interfejs
 * 
 * */
public interface PhotoService {
  
    List<Photo> findAll();
    Photo save(Photo photo);
    Photo findByPhotoId(Long photoId);
    List<Photo> findByUser(User user);

}
