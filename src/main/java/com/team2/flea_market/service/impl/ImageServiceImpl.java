package com.team2.flea_market.service.impl;

import com.team2.flea_market.entity.Image;
import com.team2.flea_market.repository.ImageRepository;
import com.team2.flea_market.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    @SneakyThrows
    @Transactional
    public Image uploadImage(MultipartFile file, Image image) {
        Image currentOrNewImage;
        if (image == null) {
            currentOrNewImage = new Image();
        } else {
            currentOrNewImage = imageRepository.findById(image.getId()).orElseThrow();
        }
        currentOrNewImage.setSize(file.getSize());
        currentOrNewImage.setMediaType(file.getContentType());
        currentOrNewImage.setContent(file.getBytes());
        imageRepository.saveAndFlush(currentOrNewImage);
        return currentOrNewImage;
    }

}
