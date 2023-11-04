package com.team2.flea_market.service;

import com.team2.flea_market.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image uploadImage(MultipartFile file, Image image);

}
