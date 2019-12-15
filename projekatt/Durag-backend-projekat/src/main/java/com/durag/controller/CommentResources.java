package com.durag.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.durag.model.Comment;
import com.durag.model.Photo;
import com.durag.service.CommentService;
import com.durag.service.PhotoService;
 

/**
 * PCommentResources Rest-Kontroler 
 * 
 * 
 * */
@RestController
@RequestMapping("/rest")
public class CommentResources {

	/** instanca PhotoService implementacije*/
    @Autowired
    private PhotoService photoService;

    /** instanca CommentService implementacije*/
    @Autowired
    private CommentService commentService;

    //Postavljanje komentara na odredjenu sliku
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment (@RequestBody Comment comment) {  
        Photo photo = photoService.findByPhotoId(comment.getPhotoId()); // pronalazi sliku na koju hocemo da ostavimo komentar, u comentaru se nalazu id slike
        List<Comment> commentList=photo.getCommentList();
        comment.setPhoto(photo); // setuje sliku za komentar

        //  
//        if (commentList==null) {
//            commentList = new ArrayList<Comment>();
//        }
//        
//        photoService.save(photo);
        commentService.save(comment); // cuva komentara
    }
}
