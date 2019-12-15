package com.durag.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durag.dao.PhotoDao;
import com.durag.model.Photo;
import com.durag.model.User;
import com.durag.service.PhotoService;
 
/**
 * Implementacija Photo Service interfejsa
 * pristup bazi pomocu <i>Photo-DAO<i> 
 * 
 * 
 * */

@Service
public class PhotoServiceImpl implements PhotoService {

	/** PhotoDAO instanca*/
    @Autowired
    private PhotoDao photoDao;


    public Photo findByPhotoId(Long photoId) {
        return photoDao.findByPhotoId(photoId);  //vrati sliku
    }
    public List<Photo> findAll() {
        return photoDao.findAll();  // lista svih slika
    }
    public Photo save(Photo photo) {
        return photoDao.save(photo);  //sacuvaj sliku
    }
    public List<Photo> findByUser(User user) {
        return photoDao.findByUser(user); // lista slika odrednjenog korisnika
    }
    
}
