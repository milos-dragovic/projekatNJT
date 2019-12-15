package com.durag.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durag.model.Photo;
import com.durag.service.PhotoService;
 
/**
 * PhotoKonroller Rest-Kontroler 
 * 
 * 
 * */
@RestController
@RequestMapping("/photo")
public class PhotoController {

	/** instanca PhotoService implementacije*/
    @Autowired
    private PhotoService photoService;
    //prikaz svih slika
    @RequestMapping("/allPhotos")
    public List<Photo> getAllPhotos () {
        return photoService.findAll(); //vraca listu svih slika
    }

}
