package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.entity.Ad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdMapper {

    /**
     * Используй для маппинг в {@link Ad}
     *
     * @param adDto {@link AdDto}
     * @return {@link Ad}
     */
    @Mapping(target = "id", source = "pk")
    @Mapping(target = "user.id", source = "author")
    Ad toEntity(AdDto adDto);

    /**
     * Используй для маппинга при апдейте в {@link Ad}
     *
     * @param adDto {@link CreateOrUpdateAdDto}
     * @param ad    {@link Ad}
     * @return {@link Ad}
     */
    Ad createOrUpdateAd(CreateOrUpdateAdDto adDto, @MappingTarget Ad ad);

    /**
     * Используй для маппинга в {@link AdDto}
     *
     * @param ad {@link Ad}
     * @return {@link AdDto}
     */
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "user.id")
    AdDto toDto(Ad ad);
}
