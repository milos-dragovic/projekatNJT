package com.durag.controller;

 
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.durag.model.Photo;
import com.durag.model.User;
import com.durag.service.PhotoService;

/**
 * PhotoResource Rest-Kontroler 
 * 
 * 
 * */

@RestController
@RequestMapping("/rest")
public class PhotoResource {

    private String imageName; //ime slike

    /** instanca PhotoService implementacije*/
    @Autowired
    private PhotoService photoService;
 
    // aploud slike
    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public String upload(HttpServletResponse response, HttpServletRequest request) {
        MultipartHttpServletRequest multparttRequest = (MultipartHttpServletRequest) request; //multipart request
        Iterator<String> iterator = multparttRequest.getFileNames();
        MultipartFile multipartFile = multparttRequest.getFile(iterator.next());
        String fileName = multipartFile.getOriginalFilename();
        imageName=fileName;
        String imagePath = new File("src\\main\\resources\\static\\images").getAbsolutePath()+"\\"+fileName;  //absoulute path
        try {
            multipartFile.transferTo(new File(imagePath));
            System.out.println(imagePath); //stampanje putanje
        } catch (IOException e) { 
            e.printStackTrace();
        }
        return "Upload Success!";
    }
    //dodavanje slike
    @RequestMapping(value = "/photo/add", method = RequestMethod.POST)
    public Photo addPhoto(@RequestBody Photo photo) {
        photo.setImageName(imageName);  // dodavanje imena za sliku
        return photoService.save(photo);  // cuvanje slike
    }
    // listu slika trazenog korisnika
    @RequestMapping(value="/photo/user", method = RequestMethod.POST)
    public List<Photo> getPhotosByUser (@RequestBody User user) {
    	return photoService.findByUser(user);   // lista slika odredjenog korisnika
    }
    //update slike
    @RequestMapping(value = "/photo/update", method = RequestMethod.POST)
    public void updatePhoto(@RequestBody Photo photo) {
        Photo currentPhoto = photoService.findByPhotoId(photo.getPhotoId()); //odgovarajuca slika
        currentPhoto.setLikes(photo.getLikes()); // podesi lajkove
        photoService.save(currentPhoto); // sacuvaj promene
    }
    // slika po odgovarajucem id-u
    @RequestMapping(value="/photo/photoId", method = RequestMethod.POST)
    public Photo getPhotoByPhotoId (@RequestBody Long photoId) {
    	return photoService.findByPhotoId(photoId); //vraca trazenu sliku
    }
    
}
