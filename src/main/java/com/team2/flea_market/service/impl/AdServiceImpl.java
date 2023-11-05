package com.team2.flea_market.service.impl;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.AdsDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.dto.ad.ExtendedAdDto;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.Image;
import com.team2.flea_market.entity.User;
import com.team2.flea_market.exception.AdNotFoundException;
import com.team2.flea_market.exception.EntityConversionException;
import com.team2.flea_market.mapper.AdMapper;
import com.team2.flea_market.repository.AdRepository;
import com.team2.flea_market.service.AdService;
import com.team2.flea_market.service.ImageService;
import com.team2.flea_market.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;
    private final ImageService imageService;
    private final SecurityService securityService;

    @Override
    public AdsDto findAllAds() {
        List<AdDto> results = adRepository.findAll().stream()
                .map(adMapper::toDto)
                .toList();
        return adMapper.toAdsDto(results);
    }

    @Override
    @Transactional
    public AdDto createAd(CreateOrUpdateAdDto createOrUpdateAdDto, MultipartFile image) {
        User currentUser = securityService.getCurrentUser();
        return Optional.of(createOrUpdateAdDto)
                .map(dto -> {
                    Ad ad = adMapper.toEntity(dto);
                    Image imageFile = imageService.uploadImage(image, ad.getImage());
                    ad.setImage(imageFile);
                    ad.setUser(currentUser);
                    adRepository.save(ad);
                    return adMapper.toDto(ad);
                })
                .orElseThrow(() -> new EntityConversionException(
                        "Ошибка преобразования, при попытке создать объявление \"%s\" пользователем \"%s\""
                                .formatted(createOrUpdateAdDto.title(), currentUser.getEmail()))
                );
    }

    @Override
    public ExtendedAdDto findAdById(Integer adId) {
        return adRepository.findById(adId)
                .map(adMapper::toExtendedAdDto)
                .orElseThrow(() -> new AdNotFoundException(adId));
    }

    @Override
    @Transactional
    public void deleteAd(Integer adId) {
        Ad ad = adRepository.findById(adId)
                .orElseThrow(() -> new AdNotFoundException(adId));
        adRepository.delete(ad);
    }

    @Override
    @Transactional
    public AdDto updateAd(Integer adId, CreateOrUpdateAdDto createOrUpdateAdDto) {
        return adRepository.findById(adId)
                .map(ad -> {
                    adMapper.toUpdateAd(createOrUpdateAdDto, ad);
                    return adRepository.save(ad);
                })
                .map(adMapper::toDto)
                .orElseThrow(() -> new AdNotFoundException(adId));
    }

    @Override
    public AdsDto findAllUserAds() {
        User currentUser = securityService.getCurrentUser();
        List<AdDto> results = adRepository.findAllByUserEmail(currentUser.getEmail()).stream()
                .map(adMapper::toDto)
                .toList();
        return adMapper.toAdsDto(results);
    }

    @Override
    @Transactional
    public Image updateAdImage(Integer adId, MultipartFile image) {
        return adRepository.findById(adId)
                .map(ad -> imageService.uploadImage(image, ad.getImage()))
                .orElseThrow(() -> new AdNotFoundException(adId));
    }

    @Override
    public Image getAdImage(Integer adId) {
        return adRepository.findById(adId)
                .map(Ad::getImage)
                .orElseThrow(() -> new AdNotFoundException(adId));
    }

}
