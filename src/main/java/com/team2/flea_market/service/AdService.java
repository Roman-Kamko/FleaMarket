package com.team2.flea_market.service;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.AdsDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.dto.ad.ExtendedAdDto;
import com.team2.flea_market.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface AdService {

    AdsDto findAllAds();

    AdDto createAd(CreateOrUpdateAdDto createOrUpdateAdDto, MultipartFile image);

    ExtendedAdDto findAdById(Integer adId);

    void deleteAd(Integer adId);

    AdDto updateAd(Integer adId, CreateOrUpdateAdDto createOrUpdateAdDto);

    AdsDto findAllUserAds();

    Image updateAdImage(Integer adId, MultipartFile image);

    Image getAdImage(Integer adId);

}
